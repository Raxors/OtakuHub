package data.api

import data.models.AnimeData
import io.ktor.client.HttpClient
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.http.parameters

interface ShikimoriApi {
    suspend fun getAnimes(): Result<List<AnimeData>>
}

class ShikimoriApiImpl(private val client: HttpClient) : ShikimoriApi {

    override suspend fun getAnimes() = client.getResults<List<AnimeData>> {
        url("animes")
        method = HttpMethod.Get
        parameters {
            append("page", "1")
            append("limit", "20")
            append("search", "Naruto")
        }
    }

}
