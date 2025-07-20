plugins {
    alias(libs.plugins.campground.android.feature)
}

android {
    namespace = "com.campground.app.feature.main"
}

dependencies {
    implementation(projects.core.router.router)
    implementation(projects.core.router.routerApi)

    implementation(projects.feature.home)
    implementation(projects.feature.homeApi)
}