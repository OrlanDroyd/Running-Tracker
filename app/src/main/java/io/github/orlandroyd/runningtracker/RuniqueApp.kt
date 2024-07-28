package io.github.orlandroyd.runningtracker

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import io.github.orlandroyd.auth.data.di.authDataModule
import io.github.orlandroyd.auth.presentation.di.authViewModelModule
import io.github.orlandroyd.core.data.di.coreDataModule
import io.github.orlandroyd.core.database.di.databaseModule
import io.github.orlandroyd.run.data.di.runDataModule
import io.github.orlandroyd.run.location.di.locationModule
import io.github.orlandroyd.run.network.di.networkModule
import io.github.orlandroyd.run.presentation.di.runPresentationModule
import io.github.orlandroyd.runningtracker.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                appModule,
                coreDataModule,
                authDataModule,
                authViewModelModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}