package com.asadmansoor.fighter.ui.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

private sealed interface Haptic

private class HapticPattern(
    val timings: LongArray,
    val amplitudes: IntArray,
    val repeat: Int
) : Haptic

/** A single composition primitive: [id] at [scale] strength (0f..1f), started after a [delayMs] pause. */
private class Primitive(val id: Int, val scale: Float = 1f, val delayMs: Int = 0)

/**
 * A haptic built from hardware [primitives] (crisper than a waveform). Devices missing any
 * requested primitive fall back to the [fallback] waveform.
 */
private class HapticComposition(
    val primitives: List<Primitive>,
    val fallback: HapticPattern
) : Haptic

/**
 * A rising staircase that builds to a full-strength pulse, pauses, then climbs again to a second peak.
 * ▁▂▂▄▅██         ▁▂▃▅████
 * ramp_up   ms:   50   50   50   50   50  100  350   25   25   25   25  200
 *          amp:   33   51   75  113  170  255    0   38   62  100  160  255
 */
private val rampUp = HapticPattern(
    timings = longArrayOf(50, 50, 50, 50, 50, 100, 350, 25, 25, 25, 25, 200),
    amplitudes = intArrayOf(33, 51, 75, 113, 170, 255, 0, 38, 62, 100, 160, 255),
    repeat = -1
)

/**
 * A smooth rise and drop, played twice.
 * ▂▄██▄▂  ▂▄██▄▂
 * swell     ms:   50   50  100   50   50  100   50   50  100   50   50
 *          amp:   64  128  255  128   64    0   64  128  255  128   64
 */
private val swell = HapticPattern(
    timings = longArrayOf(50, 50, 100, 50, 50, 100, 50, 50, 100, 50, 50),
    amplitudes = intArrayOf(64, 128, 255, 128, 64, 0, 64, 128, 255, 128, 64),
    repeat = -1
)

/**
 * A soft-then-hard "lub-dub" double pulse, played twice.
 * ▆ ██  ▆ ██
 * heartbeat ms:   60   60   90  100   60   60   90
 *          amp:  200    0  255    0  200    0  255
 */
private val heartbeat = HapticPattern(
    timings = longArrayOf(60, 60, 90, 100, 60, 60, 90),
    amplitudes = intArrayOf(200, 0, 255, 0, 200, 0, 255),
    repeat = -1
)

/**
 * A firm strike that decays into progressively softer taps with widening gaps, played twice.
 * ██  ▅   ▂    ▁  ██  ▅   ▂    ▁
 * bounce    ms:   80  100   50  150   35  220   25  100   80  100   50  150   35  220   25
 *          amp:  255    0  150    0   80    0   40    0  255    0  150    0   80    0   40
 */
private val bounce = HapticPattern(
    timings = longArrayOf(80, 100, 50, 150, 35, 220, 25, 100, 80, 100, 50, 150, 35, 220, 25),
    amplitudes = intArrayOf(255, 0, 150, 0, 80, 0, 40, 0, 255, 0, 150, 0, 80, 0, 40),
    repeat = -1
)

/**
 * A fast attack into a sustained, gravelly growl that fades out — a lion's roar.
 * ▄▆▇██▇▇██▇▇███▆▆▅▅▄▄▂▂▁▁
 * roar      ms:   40   40   40  120   80  120   80  140   90  100   90   80  120
 *          amp:  120  180  230  255  210  255  220  255  200  170  120   70   40
 */
private val roar = HapticPattern(
    timings = longArrayOf(40, 40, 40, 120, 80, 120, 80, 140, 90, 100, 90, 80, 120),
    amplitudes = intArrayOf(120, 180, 230, 255, 210, 255, 220, 255, 200, 170, 120, 70, 40),
    repeat = -1
)

/**
 * A gentle build that lands on a crisp click, using hardware primitives for a sharper feel.
 * Falls back to [swell] on devices without composition support.
 */
private val tap = HapticComposition(
    primitives = listOf(
        Primitive(VibrationEffect.Composition.PRIMITIVE_SLOW_RISE),
        Primitive(VibrationEffect.Composition.PRIMITIVE_CLICK)
    ),
    fallback = swell
)

private val patternsByKey: Map<String, Haptic> = mapOf(
    "ramp_up" to rampUp,
    "swell" to swell,
    "heartbeat" to heartbeat,
    "bounce" to bounce,
    "roar" to roar,
    "tap" to tap
)

fun Context.playHaptic(key: String?) {
    val pattern = patternsByKey[key?.lowercase()] ?: rampUp

    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        (getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager).defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }
    if (!vibrator.hasVibrator()) return

    vibrator.vibrate(pattern.toEffect(vibrator))
}

private fun Haptic.toEffect(vibrator: Vibrator): VibrationEffect = when (this) {
    is HapticPattern -> VibrationEffect.createWaveform(timings, amplitudes, repeat)
    is HapticComposition -> {
        if (primitives.all { vibrator.areAllPrimitivesSupported(it.id) }) {
            primitives
                .fold(VibrationEffect.startComposition()) { composition, primitive ->
                    composition.addPrimitive(primitive.id, primitive.scale, primitive.delayMs)
                }
                .compose()
        } else {
            VibrationEffect.createWaveform(fallback.timings, fallback.amplitudes, fallback.repeat)
        }
    }
}
