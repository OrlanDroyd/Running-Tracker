plugins {
    alias(libs.plugins.runningtracker.android.library)
}

android {
    namespace = "io.github.orlandroyd.core.notification"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.presentation.designsystem)
}