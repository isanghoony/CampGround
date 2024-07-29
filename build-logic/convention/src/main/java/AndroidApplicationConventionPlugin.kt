import com.android.build.api.dsl.ApplicationExtension
import com.isanghoony.campground.ExtensionType
import com.isanghoony.campground.configureBuildTypes
import com.isanghoony.campground.configureKotlinAndroid
import com.isanghoony.campground.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application") // 안드로이드 애플리케이션 플러그인 적용
                apply("org.jetbrains.kotlin.android") // 코틀린 안드로이드 플러그인 적용
            }

            extensions.configure<ApplicationExtension>{
                defaultConfig {
                    applicationId = libs.findVersion("projectApplicationId").get().toString() // 애플리케이션 ID 설정
                    targetSdk = libs.findVersion("projectTargetSdk").get().toString().toInt() // 타겟 SDK 버전 설정

                    versionCode = libs.findVersion("projectVersionCode").get().toString().toInt() // 버전 코드 설정
                    versionName = libs.findVersion("projectVersionName").get().toString() // 버전 이름 설정
                }

                configureKotlinAndroid(commonExtension = this) // Kotlin Android 설정 함수 호출
                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.APPLICATION) // 빌드 타입 설정 함수 호출
            }
        }
    }
}
