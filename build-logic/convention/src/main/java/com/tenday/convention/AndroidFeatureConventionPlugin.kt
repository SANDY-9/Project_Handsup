package com.tenday.convention

import com.tenday.convention.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            pluginManager.run {
                apply("tenday.hilt")
                apply("tenday.android.compose")
            }

            dependencies {
                // module
                "implementation"(project(":core:model"))
                "implementation"(project(":core:domain"))
                "implementation"(project(":core:common"))
                "implementation"(project(":core:designsystem"))
                "implementation"(project(":core:navigation"))

                "implementation"(libs.findBundle("androidx").get())
                "implementation"(libs.findLibrary("hilt-navigation-compose").get())
                "testImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("espresso-core").get())
            }
        }
    }
}