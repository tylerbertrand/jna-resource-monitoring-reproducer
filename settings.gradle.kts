plugins {
    id("com.gradle.develocity") version "3.19.2"
    id("com.gradle.common-custom-user-data-gradle-plugin") version "2.2.1"
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies {
        classpath("com.bmuschko:gradle-docker-plugin:8.0.0")
    }
}

develocity {
    server = "https://ge.solutions-team.gradle.com"
    buildScan {
        publishing.onlyIf { it.isAuthenticated }
    }
}

rootProject.name = "jna-resource-monitoring-reproducer"
