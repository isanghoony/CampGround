import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.kotlin.library.serialization)
}

setNamespace("feature.api")

dependencies {
    implementation(projects.core.router.routerApi)
}
