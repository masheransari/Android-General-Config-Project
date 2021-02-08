package com.org.dotinfiny.name

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@HiltAndroidApp
class MainApplication : Application() {

    val applicationScope = CoroutineScope(Dispatchers.Default)

    companion object {
        private var context: Context? = null

        fun getAppContext(): Context? {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        context = applicationContext
    }

}