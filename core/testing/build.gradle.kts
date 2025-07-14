plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.hilt)
}

android {
    namespace = "com.campground.core.testing"
}

dependencies {
    api(libs.kotlinx.coroutines.test)
    api(projects.core.common)
    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.hilt.android.testing)
}
