package kz.flyingv.shutapp

import android.app.Application
import appDiModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            androidLogger()
            modules(appDiModules)
        }

    }

}