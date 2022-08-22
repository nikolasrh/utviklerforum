plugins {
    application
    kotlin("jvm") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.arrow-kt:arrow-core:1.0.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

group = "nikolasrh.utviklerforum"
version = "0.0.1"
application { mainClass.set("nikolasrh.utviklerforum.AppKleisliKt") }

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "SKIPPED", "FAILED")
        showExceptions = true
        showCauses = true
        showStackTraces = true
        setExceptionFormat("FULL")
    }
}
