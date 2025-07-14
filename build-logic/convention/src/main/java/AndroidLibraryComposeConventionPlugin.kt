import com.android.build.api.dsl.LibraryExtension
import com.campground.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("campground.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension) // Android Compose 설정 함수 호출
        }
    }
}