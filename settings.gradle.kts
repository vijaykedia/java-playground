rootProject.name = "java-playground"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

// Auto include subprojects as modules
val excludedDirectories = listOf("build", "buildSrc")
fun registerAsModule(parent: File) {
    parent.listFiles()
        ?.asSequence() // Use a sequence for lazy evaluation
        ?.filter { it.isDirectory && it.name !in excludedDirectories && !it.name.startsWith(".") }
        ?.forEach { dir ->
            if (File(dir, "build.gradle.kts").exists() || File(dir, "build.gradle").exists()) {
                include(dir.name)
                project(":${dir.name}").projectDir = dir
            } else {
                registerAsModule(dir)
            }
        }
}
registerAsModule(rootDir)
