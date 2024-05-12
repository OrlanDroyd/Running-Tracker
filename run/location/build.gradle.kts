plugins {
    alias(libs.plugins.runningtracker.android.library)
}

android {
    namespace = "io.github.orlandroyd.run.location"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    implementation(projects.core.domain)
    implementation(projects.run.domain)
}