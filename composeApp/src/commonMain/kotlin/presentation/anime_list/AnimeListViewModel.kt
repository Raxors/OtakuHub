package presentation.anime_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.repository.OtakuHubRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class AnimeListViewModel(
    private val repository: OtakuHubRepository
) : ViewModel(), KoinComponent {

    var state by mutableStateOf(AnimeListUiState())
        private set

    init {
        getAnimeList()
    }

    private fun getAnimeList() {
        viewModelScope.launch {
            val result = repository.getAnimeList()
            result.onSuccess { list ->
                state = state.copy(list = list, isLoading = false, isRefreshing = false)
            }.onFailure {
                //TODO handle error
            }
        }
    }

    fun refresh() {
        state = state.copy(isRefreshing = true)
        getAnimeList()
    }

}