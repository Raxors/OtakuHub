package presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState
import domain.models.Anime
import kotlinx.serialization.Serializable
import openWebBrowser
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.publicvalue.multiplatform.oidc.OpenIdConnectClient
import org.publicvalue.multiplatform.oidc.appsupport.CodeAuthFlowFactory
import org.publicvalue.multiplatform.oidc.flows.CodeAuthFlow
import org.publicvalue.multiplatform.oidc.types.CodeChallengeMethod

@Serializable
object AuthScreen {

    const val SCREEN_ID = "AuthScreen"

    @Composable
    fun Content(navController: NavHostController) {
        AuthScreen(navController)
    }
}

@OptIn(KoinExperimentalAPI::class, ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: AuthViewModel = koinViewModel<AuthViewModel>()
) {
    val state = viewModel.state

//    val webViewState =
//        rememberWebViewState("https://shikimori.one/oauth/authorize?client_id=WGmqt2i159UZZZX-gCugOWh_Cmobxuf4kI_4Q3Qt574&redirect_uri=urn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob&response_type=code&scope=")
//    val navigator = rememberWebViewNavigator()

    val client = OpenIdConnectClient(discoveryUri = "<discovery url>") {
        endpoints {
            tokenEndpoint = "https://shikimori.one/oauth/token"
            authorizationEndpoint = "https://shikimori.one/oauth/authorize"
            userInfoEndpoint = null
            endSessionEndpoint = null
        }

        clientId = "WGmqt2i159UZZZX-gCugOWh_Cmobxuf4kI_4Q3Qt574"
        clientSecret = "VxGojWJVqNXzuAFMWc2q1oKFzU6Ha3h7Bp1HcADdUL4"
        scope = "openid profile"
        codeChallengeMethod = CodeChallengeMethod.S256
        redirectUri = "urn:ietf:wg:oauth:2.0:oob"
    }

//    val flow =
//    val tokens = flow.getAccessToken()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
//                client.
//                openWebBrowser("https://shikimori.one/oauth/authorize?client_id=WGmqt2i159UZZZX-gCugOWh_Cmobxuf4kI_4Q3Qt574&redirect_uri=urn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob&response_type=code&scope=")
            }
        ) {
            Text("Shikimori Login")
        }
//        WebView(
//            modifier = Modifier.fillMaxSize(),
//            state = webViewState,
//            navigator = navigator
//        )
    }

}