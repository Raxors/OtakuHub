package domain.models

import data.models.AnimeData
import utils.Mapper


data class Anime(
    val id: Int,
    val name: String? = null,
    val russian: String? = null,
    val imageData: Image? = null,
    val url: String? = null,
    val kind: String? = null,
    val score: String? = null,
    val status: String? = null,
    val episodes: Int? = null,
    val episodesAired: Int? = null,
    val airedOn: String? = null,
    val releasedOn: String? = null
)

object AnimeDataToModelMapper : Mapper<AnimeData, Anime> {
    override fun map(from: AnimeData): Anime = Anime(
        id = from.id,
        name = from.name,
        russian = from.russian,
        imageData = from.imageData?.let { ImageDataToModelMapper.map(it) },
        url = from.url,
        kind = from.kind,
        score = from.score,
        status = from.status,
        episodes = from.episodes,
        episodesAired = from.episodesAired,
        airedOn = from.airedOn,
        releasedOn = from.releasedOn
    )
}

object AnimeToDataMapper : Mapper<Anime, AnimeData> {
    override fun map(from: Anime): AnimeData = AnimeData(
        id = from.id,
        name = from.name,
        russian = from.russian,
        imageData = from.imageData?.let { ImageToDataMapper.map(it) },
        url = from.url,
        kind = from.kind,
        score = from.score,
        status = from.status,
        episodes = from.episodes,
        episodesAired = from.episodesAired,
        airedOn = from.airedOn,
        releasedOn = from.releasedOn
    )
}