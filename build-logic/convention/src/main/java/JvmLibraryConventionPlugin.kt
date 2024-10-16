import com.campground.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm") // Kotlin JVM 플러그인 적용
            }
            configureKotlinJvm() // Kotlin JVM 설정 함수 호출
        }
    }
}