import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies {
        classpath("com.bmuschko:gradle-docker-plugin:8.0.0")
    }
}

apply(plugin = "com.bmuschko.docker-remote-api")

tasks.register<DockerBuildImage>("dockerBuildImage") {
    inputDir.set(layout.projectDirectory.dir("docker/app"))
    images.add("test/app:1.0.0")
}
