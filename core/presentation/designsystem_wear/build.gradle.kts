plugins {
    alias(libs.plugins.runningtracker.android.library.compose)
}

android {
    namespace = "io.github.orlandroyd.core.presentation.designsystem_wear"
    compileSdk = 34

    defaultConfig {
        minSdk = 30
    }
}

dependencies {
    api(projects.core.presentation.designsystem)

    implementation(libs.androidx.wear.compose.material)
}