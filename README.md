# JNA Resource Monitoring Reproducer

Attempts to reproduce an issue where a shadowed version of JNA prevents Develocity from setting up resource usage monitoring in Build Scans. 
```
[Resource-Usage] Failed to initialize JNA. Instantiated JNA is version '8.0.0'. Please update to 5.15.0 or later.
```
The reported version of JNA in the error message was also inaccurate. It reported the version of the dependency shadowing JNA (`com.bmuschko:gradle-docker-plugin:8.0.0`) instead of the actual JNA version.

The project adds `com.bmuschko:gradle-docker-plugin:8.0.0` as a buildscript dependency and registers a task to build a Docker image.

The image can be built with `./gradlew dockerBuildImage`. The Build Scan shows that `gradle-docker-plugin` has `net.java.dev.jna:jna:5.8.0`, but resource usage monitoring seems to be [working just fine](https://ge.solutions-team.gradle.com/s/ar6crazh4mxo4/timeline).