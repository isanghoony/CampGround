plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.campground.android.library.compose)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.campground.core.designsystem"
}

dependencies {
    api(libs.bundles.compose)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material.iconsExtended)
}