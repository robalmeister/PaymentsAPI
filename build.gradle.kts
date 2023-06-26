import com.vanniktech.maven.publish.SonatypeHost

plugins {
    `java-library`
    id("com.vanniktech.maven.publish") version "0.25.2"
}



repositories {
    mavenCentral()
}

dependencies {
    api("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")
    api("com.google.code.gson:gson:2.10.1")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    api("commons-codec:commons-codec:1.16.0")

}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))

}

