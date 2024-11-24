val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val postgres_version: String by project
val aws_sdk_version: String by project

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.11"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
}

group = "com.swipingchef"
version = "0.0.1"

application {
    mainClass.set("com.planMyMealBackend.MainKt")

    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

tasks.named<JavaExec>("run") {
    args = listOf("-config=application.conf", "-config=application-local.conf")
}

repositories {
    mavenCentral()
}

dependencies {
    // Other necessary dependencies
    implementation("com.github.excitement-engineer:ktor-graphql:3.0.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.1")

    implementation("org.postgresql:postgresql:$postgres_version")

    implementation("aws.sdk.kotlin:s3:$aws_sdk_version")
    implementation("aws.sdk.kotlin:ses:$aws_sdk_version")

    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("io.ktor:ktor-serialization-jackson-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-cors-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-conditional-headers-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-apache-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-jetty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
}
