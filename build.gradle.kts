import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage

apply(plugin = "com.bmuschko.docker-remote-api")

tasks.register<DockerBuildImage>("dockerBuildImage") {
    inputDir.set(layout.projectDirectory.dir("docker/app"))
    images.add("test/app:1.0.0")
}
