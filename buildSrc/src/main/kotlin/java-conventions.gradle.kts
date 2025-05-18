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
        ktfmt().googleStyle()
    }
    kotlin {
        target("src/*/kotlin/**/*.kt")
        ktlint()
        ktfmt().googleStyle()
    }
    java {
        target("src/*/java/**/*.java")
        googleJavaFormat()
    }
    flexmark {
        target("**/*.md")
    }
}

tasks.withType<JavaCompile> {
    dependsOn(tasks.named ("spotlessApply"))
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
