plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.library.compose)
}

android {
    namespace = "com.campground.core.ui"
}

dependencies {
    api(projects.core.designsystem)
    api(projects.core.model)
    api(libs.androidx.metrics)
}