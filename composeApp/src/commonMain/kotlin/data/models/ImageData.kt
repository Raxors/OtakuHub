package data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageData(
    @SerialName("original")
    val original: String? = null,
    @SerialName("preview")
    val preview: String? = null,
    @SerialName("x96")
    val x96: String? = null,
    @SerialName("x48")
    val x48: String? = null
)