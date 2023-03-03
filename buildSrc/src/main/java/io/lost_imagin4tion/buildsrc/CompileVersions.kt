package io.lost_imagin4tion.buildsrc

import org.gradle.api.JavaVersion

object CompileVersions {
    const val KOTLIN_VERSION = "1.8.0"
    const val BUILD_GRADLE_PLUGIN_VERSION = "7.4.2"

    val JAVA_COMPILE_VERSION = JavaVersion.VERSION_1_8
    const val JVM_VERSION = "1.8"
    const val KOTLIN_COMPILER_EXTENSION_VERSION = "1.4.0"

    const val CURRENT_COMPILE_VERSION = 33
    const val MINIMUM_COMPILE_VERSION = 29
}
