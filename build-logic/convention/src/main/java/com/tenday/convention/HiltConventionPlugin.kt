package com.tenday.convention

import com.tenday.convention.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            pluginManager.run {
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.jvm")
            }

            dependencies {
                "ksp"(libs.findLibrary("hilt-compiler").get())
                "implementation"(libs.findLibrary("hilt-android").get())
                "implementation"(libs.findLibrary("hilt-core").get())
                "TestImplementation"(libs.findLibrary("hilt-android-testing").get())
            }

        }
    }
}