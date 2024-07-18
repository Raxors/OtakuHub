package presentation.anime_list

import domain.models.Anime

data class AnimeListUiState(
    val list: List<Anime> = listOf(),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false
)