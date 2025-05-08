plugins {
    java
    id("com.diffplug.spotless")
}

dependencies {
    implementation(libs.jetbrains.annotations)
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
