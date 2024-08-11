package io.github.orlandroyd.wear.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.github.orlandroyd.core.notification.ActiveRunService
import io.github.orlandroyd.core.presentation.designsystem_wear.RuniqueTheme
import io.github.orlandroyd.wear.run.presentation.TrackerScreenRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            RuniqueTheme {
                TrackerScreenRoot(
                    onServiceToggle = { shouldStartRunning ->
                        if (shouldStartRunning) {
                            startService(
                                ActiveRunService.createStartIntent(
                                    context = applicationContext,
                                    activityClass = this::class.java
                                )
                            )
                        } else {
                            startService(
                                ActiveRunService.createStopIntent(
                                    context = applicationContext
                                )
                            )
                        }
                    }
                )
            }
        }
    }
}