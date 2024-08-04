plugins {
    alias(libs.plugins.runningtracker.android.library)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "io.github.orlandroyd.core.connectivity.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.play.services)
    implementation(libs.play.services.wearable)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.connectivity.domain)
}