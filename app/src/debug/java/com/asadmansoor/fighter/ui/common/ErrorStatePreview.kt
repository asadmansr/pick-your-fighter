package com.asadmansoor.fighter.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ErrorStatePreview() {
    ErrorState(
        message = "Something went wrong. Please try again.",
        innerPaddingValues = PaddingValues(),
    )
}
