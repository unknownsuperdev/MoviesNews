A concise Android app for browsing Movies & News.

## Architecture
MVVM (Model–View–ViewModel) with Repository pattern and UseCases. Using the MVVM architecture was one of the requirements for completing the task.

## Tech Stack
- Kotlin, AndroidX
- Modules: androidApp, common:models, common:mvvm, common:network, common:response, composeApp, screens, shared
- Key libraries: coil, koin, material, material3, okhttp
- UI: Jetpack Compose

## Features
- 
OkHttp client- Image loading with Coil- Jetpack Compose UI- Lifecycle-aware ViewModel

## Notes
- Keep dependencies and Gradle plugins up to date.
- Suggested checks: `./gradlew lint test`.

## Demo video
[Download demo video](media/demo.mp4)