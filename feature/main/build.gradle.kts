import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.feature)
}

setNamespace("feature.main")

dependencies {
    implementation(projects.core.router.router)
    implementation(projects.core.router.routerApi)

    implementation(projects.feature.home)
    implementation(projects.feature.homeApi)

    androidTestImplementation(projects.core.testing)
}