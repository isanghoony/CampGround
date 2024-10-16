plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.retrofit)
    alias(libs.plugins.campground.android.hilt)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.campground.core.network"
}
dependencies {
    api(projects.core.common)
    api(projects.core.model)

    implementation(libs.androidx.tracing.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}
