plugins {
    alias(libs.plugins.runningtracker.android.library)
}

android {
    namespace = "io.github.orlandroyd.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}