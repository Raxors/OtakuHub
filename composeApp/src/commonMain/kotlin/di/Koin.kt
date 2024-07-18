package di

import data.api.ShikimoriApi
import data.api.ShikimoriApiImpl
import data.repository.OtakuHubRepositoryImpl
import domain.repository.OtakuHubRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import presentation.anime_list.AnimeListViewModel
import presentation.auth.AuthViewModel

val networkModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Application.Json)
            }
            install(UserAgent) {
                agent = "OtakuHub"
            }
            defaultRequest {
                url("https://shikimori.one/api/")
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
//                sanitizeHeader { header -> header == HttpHeaders.Authorization }
            }
        }
    }

    single<ShikimoriApi> { ShikimoriApiImpl(get()) }
//    single<MuseumStorage> { InMemoryMuseumStorage() }
}

val repositoryModule = module {
    single<OtakuHubRepository> { OtakuHubRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { AnimeListViewModel(get()) }
    viewModel { AuthViewModel(get()) }
}

fun initKoin() {
    startKoin {
        modules(
            networkModule,
            repositoryModule,
            viewModelModule
        )
    }
}
