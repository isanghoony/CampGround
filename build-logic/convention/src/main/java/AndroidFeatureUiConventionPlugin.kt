import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidFeatureUiConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("campground.android.compose")
                apply("campground.android.hilt")
            }

            dependencies {
                "implementation"(project(":core:ui"))
                "implementation"(project(":core:designsystem"))
            }
        }
    }
}
