package data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeData(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String? = null,
    @SerialName("russian")
    val russian: String? = null,
    @SerialName("image")
    val imageData: ImageData? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("kind")
    val kind: String? = null,
    @SerialName("score")
    val score: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("episodes")
    val episodes: Int? = null,
    @SerialName("episodes_aired")
    val episodesAired: Int? = null,
    @SerialName("aired_on")
    val airedOn: String? = null,
    @SerialName("released_on")
    val releasedOn: String? = null
)