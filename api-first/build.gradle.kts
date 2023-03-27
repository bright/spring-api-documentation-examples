plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("org.openapi.generator") version "6.4.0"
}


java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("io.swagger.core.v3:swagger-annotations")

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.openapitools:jackson-databind-nullable")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


val openApiGeneratorOutput get() = "${buildDir}/generated/openapi"

openApiGenerate {
    inputSpec.set("${projectDir}/openapi.yaml")
    outputDir.set(openApiGeneratorOutput)
    generateModelTests.set(false)
    generateApiTests.set(false)
    modelPackage.set("dev.bright.rest")
    apiPackage.set("dev.bright.rest")
    invokerPackage.set("dev.bright.rest.invoker")
    library.set("spring-boot")
    generatorName.set("spring")
    // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md
    configOptions.set(
        mapOf(
            "serializableModel" to "true",
            "interfaceOnly" to "true",
            "useSpringBoot3" to "true",
        )
    )
}

tasks.compileKotlin {
    dependsOn(tasks.openApiGenerate)
}

sourceSets {
    main {
        java.srcDir("${buildDir}/generated/openapi/src/main/java")
    }
}

