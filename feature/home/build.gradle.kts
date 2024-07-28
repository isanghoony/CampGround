plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.campground.android.feature.ui)
    alias(libs.plugins.campground.android.library.compose)
}

android {
    namespace = "com.campground.feature.home"
}

dependencies {
//    implementation(projects.core.data)
}