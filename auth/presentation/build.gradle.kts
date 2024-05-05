plugins {
    alias(libs.plugins.runningtracker.android.feature.ui)
}

android {
    namespace = "io.github.orlandroyd.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}