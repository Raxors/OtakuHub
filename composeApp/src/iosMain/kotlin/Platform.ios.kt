import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun openWebBrowser(url: String): Boolean {
    val website = NSURL(string = url)
    return if (UIApplication.sharedApplication.canOpenURL(website)) {
        UIApplication.sharedApplication.openURL(website)
        true
    } else false
}

actual object PlatformConstants : Constants {
    override val redirectUrl: String = "com.raxors.otakuhub://redirect"
}