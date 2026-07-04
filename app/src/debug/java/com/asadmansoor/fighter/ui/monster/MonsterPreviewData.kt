package com.asadmansoor.fighter.ui.monster

import androidx.compose.ui.graphics.Color
import com.asadmansoor.fighter.R
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

private const val PREVIEW_BACKGROUND = 0xFF2E2A4F

internal val previewMonster = MonsterImage(
    imageName = "Bat",
    drawable = R.drawable.bat,
    backgroundColor = Color(PREVIEW_BACKGROUND),
)

internal val previewMonsters: ImmutableList<MonsterImage> = persistentListOf(
    previewMonster,
    previewMonster.copy(imageName = "Lion", drawable = R.drawable.lion),
    previewMonster.copy(imageName = "Ghost", drawable = R.drawable.ghost),
)
