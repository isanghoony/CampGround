import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.compose)
}

setNamespace("core.ui")

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(libs.androidx.metrics)
}