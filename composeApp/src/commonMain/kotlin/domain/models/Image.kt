package domain.models

import data.models.ImageData
import utils.Mapper


data class Image(
    val original: String? = null,
    val preview: String? = null,
    val x96: String? = null,
    val x48: String? = null
)

object ImageDataToModelMapper : Mapper<ImageData, Image> {
    override fun map(from: ImageData): Image = Image(
        original = from.original,
        preview = from.preview,
        x96 = from.x96,
        x48 = from.x48
    )
}

object ImageToDataMapper : Mapper<Image, ImageData> {
    override fun map(from: Image): ImageData = ImageData(
        original = from.original,
        preview = from.preview,
        x96 = from.x96,
        x48 = from.x48
    )
}