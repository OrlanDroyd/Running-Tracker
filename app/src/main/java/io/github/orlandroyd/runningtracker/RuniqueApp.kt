package io.github.orlandroyd.runningtracker

import android.app.Application
import io.github.orlandroyd.auth.data.di.authDataModule
import io.github.orlandroyd.auth.presentation.di.authViewModelModule
import io.github.orlandroyd.runningtracker.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule
            )
        }
    }
}