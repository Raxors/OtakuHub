interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun openWebBrowser(url: String): Boolean

interface Constants {
    val redirectUrl: String
}

expect object PlatformConstants: Constants