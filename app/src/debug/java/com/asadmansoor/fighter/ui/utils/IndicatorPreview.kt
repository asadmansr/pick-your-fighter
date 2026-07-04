package com.asadmansoor.fighter.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true,
    backgroundColor = PREVIEW_DARK_BACKGROUND
)
@Composable
fun IndicatorDarkBackgroundPreview() {
    Indicator(
        currentPage = 4,
        totalPage = 10,
        backgroundColor = Color(PREVIEW_DARK_BACKGROUND)
    )
}

@Preview(
    showBackground = true,
    backgroundColor = PREVIEW_LIGHT_BACKGROUND
)
@Composable
fun IndicatorLightBackgroundPreview() {
    Indicator(
        currentPage = 4,
        totalPage = 10,
        backgroundColor = Color(PREVIEW_LIGHT_BACKGROUND)
    )
}
