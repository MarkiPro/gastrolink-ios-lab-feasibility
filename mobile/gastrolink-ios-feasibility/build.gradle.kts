// Deliberately independent of the accepted Android-only Compose and Pocket builds.
// Kotlin 2.4.21 supports AGP 9.3.1; existing Kotlin 2.4.10/AGP 9.3.0 is not
// a verified Kotlin Multiplatform toolchain (per JetBrains compatibility table).
plugins {
    kotlin("multiplatform") version "2.4.21" apply false
    id("com.android.kotlin.multiplatform.library") version "9.3.1" apply false
    id("org.jetbrains.compose") version "1.12.2" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.4.21" apply false
}
