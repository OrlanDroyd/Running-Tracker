plugins {
    alias(libs.plugins.runningtracker.android.library)
    alias(libs.plugins.runningtracker.android.room)
}

android {
    namespace = "io.github.orlandroyd.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}