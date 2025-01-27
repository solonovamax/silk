plugins {
    idea
    `dokka-script-root`
}

repositories {
    mavenCentral()
}

allprojects {
    group = "gay.solonovamax"
    version = "1.11.0-all-prs-SNAPSHOT"
    if (this.name.startsWith("silk")) {
        description = "Silk is a Minecraft API for Kotlin"
    }
}

idea {
    module {
        excludeDirs.add(file("docs"))
    }
}
