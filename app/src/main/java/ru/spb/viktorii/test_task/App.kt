package ru.spb.viktorii.test_task

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.spb.viktorii.test_task.catalog_screen.di.catalogModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(catalogModule)
        }
    }
}