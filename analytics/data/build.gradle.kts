plugins {
    alias(libs.plugins.runningtracker.android.library)
}

android {
    namespace = "io.github.orlandroyd.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}