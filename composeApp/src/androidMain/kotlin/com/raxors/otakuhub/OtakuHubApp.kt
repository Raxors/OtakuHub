package com.raxors.otakuhub

import android.app.Application
import di.initKoin

class OtakuHubApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        instancce = this
    }

    companion object {
        var instancce: OtakuHubApp? = null
            private set
    }
}