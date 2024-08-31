plugins {
    alias(libs.plugins.runningtracker.android.library)
    alias(libs.plugins.runningtracker.android.junit5)
}

android {
    namespace = "io.github.orlandroyd.core.android_test"
}

dependencies {
    implementation(projects.auth.data)
    implementation(projects.core.domain)
    api(projects.core.test)

    implementation(libs.ktor.client.mock)
    implementation(libs.bundles.ktor)
    implementation(libs.coroutines.test)
}