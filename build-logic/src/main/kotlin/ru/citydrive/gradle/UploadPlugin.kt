package ru.citydrive.gradle

import com.android.build.api.artifact.SingleArtifact
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.lang.IllegalStateException

class UploadPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val androidComponents = project.extensions
            .findByType(AndroidComponentsExtension::class.java) ?: throw IllegalStateException("android plugin not found")

        androidComponents.onVariants { variant ->
            val variantName = variant.name.capitalize()
            val apkFileFromVariant = variant.artifacts.get(SingleArtifact.APK)
            project.tasks.register("uploadApkFor$variantName", UploadTask::class.java) {
                apkDir.set(apkFileFromVariant)
                //uploadApkForDebug.dependsOn(assembleDebug)
            }
        }
    }
}