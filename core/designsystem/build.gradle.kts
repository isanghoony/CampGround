import com.campground.setNamespace

plugins {
    alias(libs.plugins.campground.android.compose)
}

setNamespace("core.designsystem")

dependencies {
    implementation(libs.androidx.appcompat)
}