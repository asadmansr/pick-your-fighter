package com.asadmansoor.fighter.ui.monster

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class MonsterImage(
    val imageName: String,
    @get:DrawableRes val drawable: Int,
    val backgroundColor: Color,
    val haptic: String? = null,
)
