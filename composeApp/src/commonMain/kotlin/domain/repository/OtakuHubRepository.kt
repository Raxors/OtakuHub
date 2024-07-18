package domain.repository

import domain.models.Anime

interface OtakuHubRepository {

    suspend fun getAnimeList(): Result<List<Anime>>

}