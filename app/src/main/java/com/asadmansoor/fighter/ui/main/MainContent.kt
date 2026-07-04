package com.asadmansoor.fighter.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asadmansoor.fighter.ui.common.ErrorState
import com.asadmansoor.fighter.ui.common.LoadingState
import com.asadmansoor.fighter.ui.monster.MonsterPager

@Composable
fun MainContent(
    innerPaddingValues: PaddingValues,
    viewModel: MainViewModel = viewModel(),
) {
    when (val state = viewModel.uiState.collectAsStateWithLifecycle().value) {
        is MonsterUiState.Loading -> LoadingState(innerPaddingValues)
        is MonsterUiState.Error -> ErrorState(state.message, innerPaddingValues)
        is MonsterUiState.Success -> MonsterPager(state.monsters, innerPaddingValues)
    }
}
