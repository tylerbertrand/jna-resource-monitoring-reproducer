# JNA Resource Monitoring Reproducer

Reproduces an issue where a shadowed version of JNA prevents Develocity from setting up resource usage monitoring in Build Scans. 
```
[Resource-Usage] Failed to initialize JNA. Instantiated JNA is version '8.0.0'. Please update to 5.15.0 or later.
```
The reported version of JNA in the error message was also inaccurate. It reported the version of the dependency shadowing JNA (`com.bmuschko:gradle-docker-plugin:8.0.0`) instead of the actual JNA version.

The project adds `com.bmuschko:gradle-docker-plugin:8.0.0` to the [settings classpath](https://ge.solutions-team.gradle.com/s/d4ugbakhf6gdk/build-dependencies?focusedDependency=WzAsMCwyLFswLDAsWzJdXV0&focusedDependencyDependenciesToggled=W1szMCw2XSxbMzAsOF1d&focusedDependencyView=dependencies_or_failure&toggled=W1swXSxbMCwwXV0), which is all it takes to trigger the [issue](https://ge.solutions-team.gradle.com/s/d4ugbakhf6gdk/console-log?page=1#L0).