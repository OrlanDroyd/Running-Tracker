plugins {
    alias(libs.plugins.runningtracker.android.feature.ui)
}

android {
    namespace = "io.github.orlandroyd.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}