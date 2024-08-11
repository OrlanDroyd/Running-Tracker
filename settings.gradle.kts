@file:Suppress("UnstableApiUsage")

include(":core:notification")


include(":core:connectivity:data")


include(":core:connectivity:domain")


include(":core:presentation:designsystem_wear")


include(":wear:run:presentation")


include(":wear:run:domain")


include(":wear:run:data")


include(":wear:app")


include(":analytics:dynamics_feature")


include(":analytics:presentation")


include(":analytics:domain")



include(":analytics:data")


pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "RunningTracker"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":auth:data")
include(":auth:domain")
include(":auth:presentation")
include(":core:presentation:designsystem")
include(":core:presentation:ui")
include(":core:domain")
include(":core:data")
include(":core:database")
include(":run:data")
include(":run:domain")
include(":run:presentation")
include(":run:location")
include(":run:network")
