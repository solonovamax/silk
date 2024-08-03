import BuildConstants.projectTitle

description = "Silk Rendering provides more a ergonomic kotlin API for working with Minecraft rendering"

plugins {
    `kotlin-project-script`
    `mod-build-script`
    `project-publish-script`
    `kotest-script`
    `dokka-script`
    kotlin("plugin.serialization")
}

val includeTransitive: Configuration by configurations.creating

dependencies {
    api(modProject(":${rootProject.name}-core"))

    includeTransitive(api("com.github.ajalt.colormath:colormath:3.6.0")!!)

    handleIncludes(project, includeTransitive)
}

val modName by extra("$projectTitle Rendering")
// val modMixinFiles by extra(listOf("${rootProject.name}-core.mixins.json"))
