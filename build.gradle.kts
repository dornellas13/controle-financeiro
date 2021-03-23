//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//
//plugins {
//    id 'org.jetbrains.kotlin.jvm' version '1.4.10'
//    id 'org.springframework.boot' version '2.5.0-SNAPSHOT'
//    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
//    id 'java'
//}
//
//
//group 'mvdornellas'
//version '1.0-SNAPSHOT'
//
//repositories {
//    mavenCentral()
//    maven { url 'https://repo.spring.io/milestone' }
//    maven { url 'https://repo.spring.io/snapshot' }
//}
//
//dependencies {
//    implementation "org.jetbrains.kotlin:kotlin-stdlib"
//    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
//    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
//    implementation 'org.springframework.boot:spring-boot-starter-web'
//    runtimeOnly 'com.h2database:h2'
//    testImplementation 'org.springframework.boot:spring-boot-starter-test'
//}
//
//
//test {
//    useJUnitPlatform()
//}
//
//tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).all {
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}


plugins {
    id("org.springframework.boot") version "2.5.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.spring") version "1.4.31"
    kotlin("plugin.jpa") version "1.4.31"
}

group = "mvdornellas"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

