plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false
}

buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${io.lost_imagin4tion.buildsrc.CompileVersions.BUILD_GRADLE_PLUGIN_VERSION}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${io.lost_imagin4tion.buildsrc.CompileVersions.KOTLIN_VERSION}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
