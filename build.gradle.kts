plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.frankhan"
version = "1"

repositories {
    mavenCentral()
    maven("https://www.jitpack.io")
}

dependencies {
    implementation("dev.hollowcube:minestom-ce:438338381e")
    implementation("ch.qos.logback:logback-core:1.4.11")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation("de.articdive:jnoise-pipeline:4.0.0")
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.withType<Jar> {
    manifest {
        // Change this to your main class
        attributes["Main-Class"] = "me.frankhan.Main"
    }
}