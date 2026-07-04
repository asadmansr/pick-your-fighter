package com.asadmansoor.fighter.ui.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp

private const val DARK_LUMINANCE_THRESHOLD = 0.5f

@Composable
fun Indicator(
    currentPage: Int,
    totalPage: Int,
    backgroundColor: Color,
) {
    val contentColor =
        if (backgroundColor.luminance() < DARK_LUMINANCE_THRESHOLD) Color.White else Color.Black
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(times = totalPage) { iteration ->
            Dot(
                selected = currentPage == iteration,
                contentColor = contentColor,
            )
        }
    }
}
