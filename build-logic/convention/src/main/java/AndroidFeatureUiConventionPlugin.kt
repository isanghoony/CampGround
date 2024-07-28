import com.isanghoony.campground.addUiLayerDependencies
import com.isanghoony.campground.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureUiConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("campground.android.library.compose") // Compose를 위한 커스텀 플러그인
                apply("dagger.hilt.android.plugin") // Dagger Hilt 플러그인
                apply("com.google.devtools.ksp") // Kotlin Symbol Processing 플러그인
            }
            dependencies {
                // addUiLayerDependencies 함수 호출을 통해 UI 계층 관련 의존성을 추가합니다.
                addUiLayerDependencies(target)
                // Hilt 라이브러리를 추가합니다.
                "implementation"(libs.findBundle("hilt").get())
                // Hilt 컴파일러를 KSP(Kotlin Symbol Processing)를 통해 추가합니다.
                "ksp"(libs.findBundle("hilt.compiler").get())
            }
        }
    }
}
