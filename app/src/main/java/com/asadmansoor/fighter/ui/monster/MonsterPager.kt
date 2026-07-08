package com.asadmansoor.fighter.ui.monster

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.asadmansoor.fighter.ui.utils.Indicator
import com.asadmansoor.fighter.ui.utils.playHaptic
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MonsterPager(
    monsters: ImmutableList<MonsterImage>,
    innerPaddingValues: PaddingValues,
) {
    val pagerState = rememberPagerState(pageCount = { monsters.size })
    val backgroundColor = monsters.getOrNull(index = pagerState.currentPage)
        ?.backgroundColor ?: Color.White
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(innerPaddingValues),
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
        ) { page ->
            val monster = monsters[page]
            MonsterPage(
                monster = monster,
                onTap = { context.playHaptic(monster.haptic) },
            )
        }
        Indicator(
            currentPage = pagerState.currentPage,
            totalPage = pagerState.pageCount,
            backgroundColor = backgroundColor,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
    }
}
