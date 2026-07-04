package com.asadmansoor.fighter.ui.monster

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MonsterPagerPreview() {
    MonsterPager(
        monsters = previewMonsters,
        innerPaddingValues = PaddingValues(0.dp),
    )
}
