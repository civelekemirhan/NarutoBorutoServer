
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    testImplementation("io.ktor:ktor-server-tests:3.0.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test:2.0.21")
    implementation("io.ktor:ktor-server-status-pages:3.0.1")
    implementation("io.ktor:ktor-server-default-headers:3.0.1")
    implementation("io.insert-koin:koin-ktor:3.4.0")
    implementation("io.insert-koin:koin-logger-slf4j:3.4.0")
}
