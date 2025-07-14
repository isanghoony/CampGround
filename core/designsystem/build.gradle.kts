plugins {
    alias(libs.plugins.campground.android.compose)
}

android {
    namespace = "com.campground.core.designsystem"
}

dependencies {
    implementation(libs.androidx.appcompat)
}