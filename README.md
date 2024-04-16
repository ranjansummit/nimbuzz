## **Triangular Image Picker**
**Introduction**

This Android application allows users to select two images from their device's library and displays them in a visually appealing triangular layout. The app utilizes Jetpack Compose for a modern and declarative UI experience, along with well-structured architecture and robust unit testing for reliable functionality.

**Features**

- User-friendly image selection from the device gallery.
- Dynamic triangular layout for displaying chosen images.
- Leverages Jetpack Compose for a smooth and customizable UI.
- Employs clean architecture principles for maintainability.
- Includes unit tests for core functionalities.

**Getting Started**

1. **Prerequisites:**
   1. Android Studio with the latest Android SDK tools installed.
   1. Basic understanding of Android development and Jetpack Compose.


1. **Importing the Project:**
   1. Open Android Studio and select "Open an existing Android Studio project."
   1. Navigate to the cloned repository directory and open the project.
1. **Setting Up Dependencies:**
   1. The project includes all necessary libraries within the build.gradle file. Ensure you have a stable internet connection during the first build to download them automatically.
1. **Running the App:**
   1. Connect an Android device to your computer or use an emulator.
   1. Click the "Run" button (green triangle) in Android Studio.
   1. Select your device or emulator from the dropdown menu.
   1. The app will be installed and launched on your device.

**Usage**

1. Grant storage permissions (if requested) to access your device's image library.
1. Select two images from your gallery using the provided UI elements.
1. The chosen images will be displayed in a dynamic triangular layout within the app.

**Architecture**

The app follows clean architecture principles, separating the UI (Jetpack Compose), domain logic (view models), and data access layer (API calls or local storage) for better maintainability and testability.

**Testing**

The codebase includes unit tests written with JUnit and Mockito to validate the functionality of the view models. This ensures robustness and helps prevent regressions during future development.

**Libraries Used**

- **Jetpack Compose:** Declarative UI framework for building modern Android apps.
- **Navigation:** Enables seamless navigation between screens within the app.
- **Hilt:** Dependency injection library for managing dependencies.
- **Retrofit:** Network library for API communication (if applicable).
- **Timber:** Logging library for debugging and monitoring.
- **Landscapist:** Image loading library with animations and transformations.
- **JUnit & Mockito:** Unit testing libraries for verifying code behavior.