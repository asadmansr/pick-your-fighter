package com.asadmansoor.fighter.ui.monster

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

private const val IMAGE_WIDTH_FRACTION = 0.8f

@Composable
fun MonsterPage(
    monster: MonsterImage
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = monster.drawable),
            contentDescription = monster.imageName,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(IMAGE_WIDTH_FRACTION)
                .weight(1f)
                .padding(24.dp),
        )
    }
}
