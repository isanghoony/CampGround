plugins {
    alias(libs.plugins.campground.android.library)
    //alias(libs.plugins.campground.android.library.jacoco)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.campground.core.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.javax.inject)

    testImplementation(projects.core.testing)
}