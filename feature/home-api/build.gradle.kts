plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.kotlin.library.serialization)
}

android {
    namespace = "com.campground.feature.api"
}

dependencies {
    implementation(projects.core.router.routerApi)
}
