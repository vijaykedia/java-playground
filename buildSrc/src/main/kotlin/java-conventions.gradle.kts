plugins {
    java
    id("com.diffplug.spotless")
}

dependencies {
    implementation(libs.jetbrains.annotations)
    testImplementation(platform(libs.junit.bom))
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)
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
    flexmark {
        target("**/*.md")
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
