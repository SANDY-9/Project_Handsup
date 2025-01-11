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

rootProject.name = "HandsUp"
include(":app")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:designsystem")
include(":core:navigation")
include(":feature:login")
include(":core:network")
include(":feature:splash")
include(":core:datastore")
include(":feature:board")
include(":feature:board-details")
include(":feature:notification")
include(":feature:home")
include(":feature:mission")
