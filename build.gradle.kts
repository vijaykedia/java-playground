plugins {
    idea
}

tasks.wrapper {
    gradleVersion = "8.14"
    distributionType = Wrapper.DistributionType.ALL
}

idea.module.isDownloadSources = true
