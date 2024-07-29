import com.android.build.api.dsl.ApplicationExtension
import com.isanghoony.campground.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application") // 안드로이드 애플리케이션 플러그인 적용
                apply("org.jetbrains.kotlin.android") // 코틀린 안드로이드 플러그인 적용
            }

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension) // Android Compose 설정 함수 호출
        }
    }
}