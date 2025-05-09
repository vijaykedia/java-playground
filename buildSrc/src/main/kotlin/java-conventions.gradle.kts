plugins {
    java
    id("com.diffplug.spotless")
}

dependencies {
    implementation(libs.jetbrains.annotations)
    testImplementation(platform(libs.junit.bom))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

spotless {
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
        ktfmt()
    }
    kotlin {
        target("src/*/kotlin/**/*.kt")
        ktlint()
        ktfmt()
    }
    java {
        target("src/*/java/**/*.java")
        googleJavaFormat()
    }
}

tasks.named("build") {
    dependsOn("spotlessApply")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
