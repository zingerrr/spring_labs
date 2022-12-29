plugins {
    id("java")
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.ilya"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:3.0.0")
    implementation("org.springframework.shell:spring-shell-starter:2.1.4")


//    implementation("org.springframework:spring-core:6.0.3")
//    implementation("org.springframework:spring-context:6.0.3")
//    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.postgresql:postgresql:42.5.1")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}