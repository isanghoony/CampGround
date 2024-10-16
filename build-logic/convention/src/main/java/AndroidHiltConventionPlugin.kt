import com.campground.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp") // Kotlin Symbol Processing 플러그인 적용
                apply("dagger.hilt.android.plugin") // Dagger Hilt 플러그인 적용
            }

            dependencies {
                "implementation"(libs.findBundle("hilt").get()) // Hilt 라이브러리 추가
                "ksp"(libs.findBundle("hilt.compiler").get()) // Hilt 컴파일러를 KSP를 통해 추가
            }
        }
    }
}