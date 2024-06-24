plugins {
    alias(libs.plugins.runningtracker.android.library)
    alias(libs.plugins.runningtracker.jvm.ktor)
}

android {
    namespace = "io.github.orlandroyd.run.network"
}

dependencies {
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.data)
}