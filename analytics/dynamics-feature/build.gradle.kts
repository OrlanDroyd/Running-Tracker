plugins {
    alias(libs.plugins.runningtracker.dynamic.feature)
}
android {
    namespace = "io.github.orlandroyd.analytics.dynamics_feature"
}

dependencies {
    implementation(project(":app"))

    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)
}