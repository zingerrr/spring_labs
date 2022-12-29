plugins {
    id("java")
    id("application")
}

group = "com.ilya"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-core:6.0.3")
    implementation("org.springframework:spring-context:6.0.3")
    implementation("org.postgresql:postgresql:42.5.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}