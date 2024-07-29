pluginManagement {
    // 'build-logic'이라는 별도의 빌드 논리 프로젝트를 포함합니다.
    includeBuild("build-logic")

    // 플러그인 리포지토리를 정의합니다.
    repositories {
        google {
            content {
                // com.android, com.google, androidx 패키지의 그룹을 포함시킵니다.
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral() // Maven Central 리포지토리를 포함시킵니다.
        gradlePluginPortal() // Gradle 플러그인 포털을 포함시킵니다.
    }
}

// 의존성 해결 관리를 위한 설정 블록입니다.
dependencyResolutionManagement {
    // 프로젝트 내의 리포지토리를 사용하지 않고, 정의된 리포지토리만 사용하도록 설정합니다.
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Google 리포지토리를 포함시킵니다.
        mavenCentral() // Maven Central 리포지토리를 포함시킵니다.
    }
}

// TYPESAFE_PROJECT_ACCESSORS 기능을 활성화합니다.
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// 프로젝트의 모듈을 포함시킵니다.
include(":app")
include(":feature:home")
include(":core:designsystem")
include(":core:ui")
include(":core:data")
include(":core:domain")
include(":core:common")
include(":core:network")
include(":core:model")
