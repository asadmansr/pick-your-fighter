package com.asadmansoor.fighter.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asadmansoor.fighter.data.MonsterFighterRepository
import com.asadmansoor.fighter.data.MonsterRepository
import com.asadmansoor.fighter.ui.monster.MonsterImage
import com.asadmansoor.fighter.ui.monster.toMonsterImage
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MonsterUiState {
    data object Loading : MonsterUiState
    data class Success(val monsters: ImmutableList<MonsterImage>) : MonsterUiState
    data class Error(val message: String) : MonsterUiState
}

class MainViewModel(
    private val repository: MonsterRepository = MonsterFighterRepository(),
) : ViewModel() {

    private val _uiState = MutableStateFlow<MonsterUiState>(MonsterUiState.Loading)
    val uiState: StateFlow<MonsterUiState> = _uiState.asStateFlow()

    init {
        loadMonsters()
    }

    private fun loadMonsters() {
        viewModelScope.launch {
            _uiState.value = MonsterUiState.Loading
            _uiState.value = try {
                val monsters = repository.getMonsters().mapNotNull { monster ->
                    monster.toMonsterImage()
                }.toImmutableList()
                MonsterUiState.Success(monsters)
            } catch (e: IOException) {
                MonsterUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}
