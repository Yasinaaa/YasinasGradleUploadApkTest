// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins.register("upload-tg-plugin") {
        id = "upload-tg-plugin"
        implementationClass = "ru.citydrive.gradle.UploadPlugin"
    }
}

dependencies {
    implementation(libs.agp)
    implementation(libs.bundles.ktor)
    implementation(libs.kotlin.gradle.plugin)
}