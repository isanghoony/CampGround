import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.retrofit)
    alias(libs.plugins.campground.android.hilt)
}

setNamespace("core.network")

android {
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.model)

    implementation(libs.androidx.tracing.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}
