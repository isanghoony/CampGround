plugins {
    alias(libs.plugins.campground.android.compose)
}

android {
    namespace = "com.campground.core.ui"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(libs.androidx.metrics)
}