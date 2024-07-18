import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.browser.customtabs.CustomTabsIntent
import com.raxors.otakuhub.OtakuHubApp

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun openWebBrowser(url: String): Boolean {
    val intent = CustomTabsIntent.Builder().build().apply {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    val context = getContext()
    return if (context != null) {
        intent.launchUrl(context, Uri.parse(url))
        true
    } else false
}

fun getContext(): Context? = OtakuHubApp.instancce

actual object PlatformConstants : Constants {
    override val redirectUrl: String = "${getContext()?.packageName}://redirect"
}