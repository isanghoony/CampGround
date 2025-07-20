plugins {
    alias(libs.plugins.campground.android.application)
    alias(libs.plugins.campground.android.application.compose)
    alias(libs.plugins.campground.android.hilt)
}

android {
    namespace = "com.isanghoony.campground"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.isanghoony.campground"
        minSdk = 26
        targetSdk = 35
        versionCode = 2
        versionName = "1.0.1"

        buildConfigField(type = "String", name = "API_BASE_URL", value = "\"http://apis.data.go.kr/B551011/GoCamping\"")
        buildConfigField(type = "String", name = "API_BASE_SERVER_KEY", value = "\"zNpViQCKKUS7WFWxKYkjnbuV7J1WAX4k8qiXZXCOb7lIi6lyDUwWxA97DGDOS9Jl2mp/+7/8KV/hsifEWiaaSA==\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.domain)

    implementation(projects.feature.main)
    implementation(projects.feature.home)
    implementation(projects.feature.homeApi)
}