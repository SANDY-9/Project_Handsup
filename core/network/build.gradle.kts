plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)
}
android {
    namespace = "com.tenday.network"
    compileSdk = 35
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
dependencies {
    // hilt
    implementation(libs.bundles.hilt)
    ksp(libs.hilt.compiler)

    // retrofit2
    implementation(libs.bundles.retrofit)
    implementation(libs.kotlinx.serialization.json)

}