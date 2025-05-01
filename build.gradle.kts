plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.8.10"
}

group = "rojojun"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    // Ktor client dependencies
    implementation("io.ktor:ktor-client-core:2.3.4")  // Ktor core
    implementation("io.ktor:ktor-client-cio:2.3.4")   // Ktor CIO client engine
    implementation("io.ktor:ktor-client-content-negotiation:2.3.4") // Content negotiation
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4") // JSON serialization

    // Kotlin serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
