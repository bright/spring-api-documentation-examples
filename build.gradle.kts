import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5" apply false
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.10" apply false
    kotlin("plugin.spring") version "1.8.10" apply false
}

group = "dev.bright"
version = "0.0.1-SNAPSHOT"

subprojects {
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencyManagement {
        dependencies {
            dependency("io.swagger.core.v3:swagger-annotations:2.2.8")
            dependency("org.openapitools:jackson-databind-nullable:0.2.6")
            dependency("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.3")
        }
    }
}
