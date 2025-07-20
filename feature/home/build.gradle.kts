plugins {
    alias(libs.plugins.campground.android.feature)
}

android {
    namespace = "com.campground.feature.home"
}

dependencies {
    implementation(projects.feature.homeApi)
}
