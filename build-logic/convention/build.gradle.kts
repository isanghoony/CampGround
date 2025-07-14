import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.isanghoony.campgtound.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
}

dependencies {
    compileOnly(libs.compose.gradle.plugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}


tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "campground.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "campground.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "campground.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "campground.android.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeature") {
            id = "campground.android.feature.ui"
            implementationClass = "AndroidFeatureUiConventionPlugin"
        }
        register("androidHilt") {
            id = "campground.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRetrofit") {
            id = "campground.android.retrofit"
            implementationClass = "AndroidRetrofitConventionPlugin"
        }
        register("jvmLibrary") {
            id = "campground.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
