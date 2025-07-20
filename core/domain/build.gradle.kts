import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.library)
    //alias(libs.plugins.campground.android.library.jacoco)
    id("com.google.devtools.ksp")
}

setNamespace("core.domain")

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.model)

    implementation(libs.javax.inject)

    testImplementation(projects.core.testing)
}