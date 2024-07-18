package data.repository

import data.api.ShikimoriApi
import domain.models.Anime
import domain.models.AnimeDataToModelMapper
import domain.repository.OtakuHubRepository
import utils.mapAll

class OtakuHubRepositoryImpl(
    private val api: ShikimoriApi
) : OtakuHubRepository {

    override suspend fun getAnimeList(): Result<List<Anime>> =
        api.getAnimes().map { AnimeDataToModelMapper.mapAll(it) }

}