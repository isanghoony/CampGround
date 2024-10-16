import com.android.build.api.dsl.LibraryExtension
import com.campground.ExtensionType
import com.campground.configureBuildTypes
import com.campground.configureKotlinAndroid
import com.campground.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library") // 안드로이드 라이브러리 플러그인 적용
                apply("org.jetbrains.kotlin.android") // 코틀린 안드로이드 플러그인 적용
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this) // Kotlin Android 설정 함수 호출

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY // 라이브러리 빌드 타입 설정 함수 호출
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // 테스트 인스트루먼트 러너 설정
                    consumerProguardFiles("consumer-rules.pro") // ProGuard 파일 설정
                }

                testOptions {
                    unitTests.all { test ->
                        test.useJUnitPlatform() // JUnit Platform 사용 설정
                    }
                }

                configureKotlinAndroid(commonExtension = this) // 중복된 Kotlin Android 설정 함수 호출 (필요 시 제거)
                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY // 중복된 빌드 타입 설정 함수 호출 (필요 시 제거)
                )
            }
            dependencies {
                add("androidTestImplementation", kotlin("test"))
                add("testImplementation", kotlin("test"))

                add("implementation", libs.findLibrary("androidx.tracing.ktx").get())
            }
        }
    }
}
