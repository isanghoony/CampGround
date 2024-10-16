plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.campground.android.application)
    alias(libs.plugins.campground.android.application.compose)
    alias(libs.plugins.campground.android.hilt)
}

android {
    namespace = "com.isanghoony.campground"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.isanghoony.campground"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField(type = "String", name = "API_BASE_URL", value = "http://apis.data.go.kr/B551011/GoCamping")
        buildConfigField(type = "String", name = "API_BASE_SERVER_KEY", value = "zNpViQCKKUS7WFWxKYkjnbuV7J1WAX4k8qiXZXCOb7lIi6lyDUwWxA97DGDOS9Jl2mp/+7/8KV/hsifEWiaaSA==")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
/*    implementation(projects.feature.home)
    implementation(projects.feature.mypage)*/

    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.domain)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}