plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.retrofit)
    alias(libs.plugins.campground.android.hilt)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.isanghoony.core.network"
}
