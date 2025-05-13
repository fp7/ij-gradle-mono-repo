plugins {
    id("org.jetbrains.intellij.platform") version "2.5.0"
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2025.1")
        bundledPlugin("com.intellij.java")
        bundledPlugin("org.jetbrains.kotlin")
        bundledPlugin("com.intellij.modules.json")
    }
}

intellijPlatform {
    buildSearchableOptions = false
    instrumentCode = false
}
