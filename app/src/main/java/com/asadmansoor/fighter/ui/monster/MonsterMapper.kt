package com.asadmansoor.fighter.ui.monster

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import com.asadmansoor.fighter.R
import com.asadmansoor.fighter.data.Monster

fun Monster.toMonsterImage(): MonsterImage? {
    val drawableId = drawableByMonster[image] ?: return null
    return MonsterImage(
        imageName = name,
        drawable = drawableId,
        backgroundColor = Color(backgroundColor.toColorInt()),
    )
}

private val drawableByMonster: Map<String, Int> = mapOf(
    "bat" to R.drawable.bat,
    "duckling" to R.drawable.duckling,
    "bunny" to R.drawable.bunny,
    "jellyfish" to R.drawable.jellyfish,
    "lion" to R.drawable.lion,
    "alien" to R.drawable.alien,
    "squid_alien" to R.drawable.squid_alien,
    "flame" to R.drawable.flame,
    "cookie" to R.drawable.cookie,
    "ghost" to R.drawable.ghost,
    "monster" to R.drawable.monster,
    "alien_monster" to R.drawable.alien_monster,
    "enemy_monster" to R.drawable.enemy_monster,
    "spooky_monster" to R.drawable.spooky_monster,
    "scary_monster" to R.drawable.scary_monster,
    "creepy_monster" to R.drawable.creepy_monster,
    "skeleton" to R.drawable.skeleton,
    "ghoul" to R.drawable.ghoul,
    "sticker_monster" to R.drawable.sticker_monster,
    "pumpkin" to R.drawable.pumpkin,
    "skull" to R.drawable.skull,
    "bee" to R.drawable.bee,
    "frog" to R.drawable.frog,
    "spider" to R.drawable.spider,
    "cactus" to R.drawable.cactus,
    "mushroom" to R.drawable.mushroom,
)
