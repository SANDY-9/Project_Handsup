plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.tenday.service"
    compileSdk = 35

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    implementation(project(":core:model"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))

    implementation(libs.bundles.androidx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.androidx.hilt.navigation.compose)


    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.bundles.firebase)
}