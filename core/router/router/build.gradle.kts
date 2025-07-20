import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.hilt)
    alias(libs.plugins.campground.android.compose)
}

setNamespace("core.router")

dependencies {
    implementation(projects.core.router.routerApi)
}