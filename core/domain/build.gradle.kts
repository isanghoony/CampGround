plugins {
    alias(libs.plugins.campground.android.library)
}

android {
    namespace = "com.isanghoony.core.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}