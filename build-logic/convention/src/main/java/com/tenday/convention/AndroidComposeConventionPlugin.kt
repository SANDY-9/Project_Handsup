package com.tenday.convention

import com.android.build.api.dsl.LibraryExtension
import com.tenday.convention.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<LibraryExtension>()
            extension.apply {
                buildFeatures {
                    compose = true
                }
            }

            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            dependencies {
                // compose
                val bom = libs.findLibrary("compose-bom").get()
                "implementation"(platform(bom))
                "implementation"(libs.findBundle("compose").get())
                "debugImplementation"(libs.findLibrary("ui-tooling").get())
                "debugImplementation"(libs.findLibrary("ui-test-manifest").get())
                "androidTestImplementation"(libs.findLibrary("ui-test-junit4").get())
                "androidTestImplementation"(libs.findLibrary("compose-bom").get())
            }
        }
    }
}