import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.feature)
}

setNamespace("feature.home")

dependencies {
    implementation(projects.feature.homeApi)
}
