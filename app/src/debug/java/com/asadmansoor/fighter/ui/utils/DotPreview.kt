package com.asadmansoor.fighter.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true,
    backgroundColor = PREVIEW_LIGHT_BACKGROUND
)
@Composable
fun DotDarkBackgroundPreview() {
    Dot(
        selected = false,
        contentColor = Color(PREVIEW_DARK_BACKGROUND)
    )
}

@Preview(
    showBackground = true,
    backgroundColor = PREVIEW_LIGHT_BACKGROUND
)
@Composable
fun SelectedDotDarkBackgroundPreview() {
    Dot(
        selected = true,
        contentColor = Color(PREVIEW_DARK_BACKGROUND)
    )
}

@Preview(
    showBackground = true,
    backgroundColor = PREVIEW_DARK_BACKGROUND
)
@Composable
fun DotLightBackgroundPreview() {
    Dot(
        selected = false,
        contentColor = Color(PREVIEW_LIGHT_BACKGROUND)
    )
}

@Preview(
    showBackground = true,
    backgroundColor = PREVIEW_DARK_BACKGROUND
)
@Composable
fun SelectedDotLightBackgroundPreview() {
    Dot(
        selected = true,
        contentColor = Color(PREVIEW_LIGHT_BACKGROUND)
    )
}
