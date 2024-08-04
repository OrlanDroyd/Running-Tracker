plugins {
    alias(libs.plugins.runningtracker.android.feature.ui)
    alias(libs.plugins.mapsPlatformSecretsPlugin)
}

android {
    namespace = "io.github.orlandroyd.run.presentation"
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.google.maps.android.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.run.domain)
    implementation(projects.core.connectivity.domain)
}