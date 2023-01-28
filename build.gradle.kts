plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "jp.osivler"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    copy {
        from("$projectDir/src/test")
        into("$projectDir/build/test")
        include("**/*.txt")
    }
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

sourceSets {
    test {
        resources {
            srcDir("src/test/kotlin")
            include("**/*.txt")
        }
    }
}
