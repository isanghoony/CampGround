
# CampGround
공공데이터포털 캠핑 API를 이용해 정보를 제공하는 앱입니다.

## Development

### Required

- IDE : Android Studio 최신 버전 ([Download](https://developer.android.com/studio))
- JDK : Java 21
- Kotlin Language : 2.0.0

### Language

- Kotlin

### Libraries

- AndroidX
    - Activity & Activity Compose
    - AppCompat
    - Core
    - Lifecycle & ViewModel Compose
    - Navigation

- Kotlin Libraries (Coroutine, DateTime, Serialization)
- Compose
    - Material3
    - Navigation

- Landscapist & Landscapist Coil
- Dagger & Hilt
- Square (Retrofit, OkHttp)

#### Test & Code analysis

- Compose Test(UI, Navigation)
- JUnit4
- Mockk
- Turbine
- Kotest
- Detekt

#### Gradle Dependency

[Gradle Version Catalog](https://docs.gradle.org/current/userguide/platforms.html) 를 활용하여 종속성과 플러그인을 관리하고 있습니다.

자세한 내용은 [libs.versions.toml](https://github.com/droidknights/DroidKnights2023_App/blob/main/gradle/libs.versions.toml) 를 참고해 주세요.

## Architecture

### Layer

본 프로젝트는 Layered Architecture 형태로 설계되어 있습니다. 현재 Presentation/Domain/Data 레이어 구조를 띄고 있습니다.

![img](https://lh6.googleusercontent.com/jIm6sL0mqukk0OROYyStYNsBulEFLZki-z2Y9OD73K-cpvEre-VP1wmdSC-bDpNJrGdhB4bOZbABRspBcn4FJCtJs4uQKKwWesOdThS-B75HwnCdTCqEKXAClxOimOtIu9WbabaP_Mpel6dDpLSSQVk)

#### UI Layer

상태는 아래로 이동하고 이벤트는 위로 이동하는 단방향 데이터 흐름(UDF)으로 구성되어 있습니다.

![img](https://lh5.googleusercontent.com/Cy5hT9u87lJ9w4mKtGOvyWIaHAUMXQJakV_1RVdjeHGeAUFMnTS1P33yan05Sw5AcPbfkI6DiXt4SupBVnziDjl-ylvNqhTb0u1uZWTgp0saetrqFYhjH0LrxTocOFIKOvOSZ26wYSJDJi6nrRUrUJg)

### Module

본 프로젝트는 Multi-module 구조이며 각 Feature마다 모듈 형태로 구성되어 있습니다.