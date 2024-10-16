plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.hilt)
}

android {
    namespace = "com.campground.core.testing"
}

dependencies {
    api(libs.kotlinx.coroutines.test)
    //api(projects.core.analytics)
    api(projects.core.common)
    api(projects.core.data)
    api(projects.core.model)
    //api(projects.core.notifications)


    //implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
    //implementation(libs.kotlinx.datetime)
}
