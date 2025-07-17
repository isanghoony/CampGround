plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.hilt)
    alias(libs.plugins.campground.android.compose)
}

android {
    namespace = "com.campground.app.core.router"
}

dependencies {
    implementation(projects.core.router.routerApi)
}