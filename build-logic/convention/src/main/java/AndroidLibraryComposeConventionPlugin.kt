import com.android.build.api.dsl.LibraryExtension
import com.campground.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("campground.android.library") // 커스텀 안드로이드 라이브러리 플러그인 적용
            }

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension) // Android Compose 설정 함수 호출
        }
    }
}