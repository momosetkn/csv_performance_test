plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // https://mvnrepository.com/artifact/com.orangesignal/orangesignal-csv
    implementation("com.orangesignal:orangesignal-csv:2.2.1")
    // https://mvnrepository.com/artifact/com.github.mygreen/super-csv-annotation
    implementation("com.github.mygreen:super-csv-annotation:2.3")
    // https://mvnrepository.com/artifact/com.univocity/univocity-parsers
    implementation("com.univocity:univocity-parsers:2.9.1")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-csv
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.15.3")
    // https://mvnrepository.com/artifact/com.github.doyaaaaaken/kotlin-csv
    implementation("com.github.doyaaaaaken:kotlin-csv:1.9.2")
    implementation("io.github.blackmo18:kotlin-grass-core-jvm:1.0.0")
    implementation("io.github.blackmo18:kotlin-grass-parser-jvm:0.8.0")
    implementation("io.github.blackmo18:kotlin-grass-date-time-jvm:0.8.0")
    // https://mvnrepository.com/artifact/com.opencsv/opencsv
    implementation("com.opencsv:opencsv:5.9")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-csv
    implementation("org.apache.commons:commons-csv:1.10.0")
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC2")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-debug:1.8.0-RC2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}