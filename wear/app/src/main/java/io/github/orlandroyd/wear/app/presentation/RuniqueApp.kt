package io.github.orlandroyd.wear.app.presentation

import android.app.Application
import io.github.orlandroyd.wear.run.data.di.wearRunDataModule
import io.github.orlandroyd.wear.run.presentation.di.wearRunPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RuniqueApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                wearRunPresentationModule,
                wearRunDataModule
            )
        }
    }
}