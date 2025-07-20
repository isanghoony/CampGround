import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.library)
}

setNamespace("core.testing")

dependencies {
    api(platform(libs.junit5.bom))
    api(libs.junit5)
    api(libs.junit5.engine)
    api(libs.junit5.platform.launcher)
    api(libs.kotlin.test)
    api(libs.mockk)
    api(libs.turbine)
    api(libs.coroutines.test)
    api(libs.roborazziRule)

    implementation(libs.hilt.android.testing)
    implementation(libs.roborazzi)
    implementation(libs.androidx.runner)
    implementation(projects.core.designsystem)
}