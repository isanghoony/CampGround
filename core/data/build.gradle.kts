plugins {
    alias(libs.plugins.campground.android.library)
    alias(libs.plugins.campground.android.hilt)
}

android {
    namespace = "com.isanghoony.core.data"
}

dependencies {
    api(projects.core.common)
    api(projects.core.network)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}