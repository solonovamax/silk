import BuildConstants.authors
import BuildConstants.githubRepo
import BuildConstants.isSnapshot

plugins {
    kotlin("jvm")

    `maven-publish`
    signing
}

publishing {
    repositories {
        maven {
            name = "ossrh"
            credentials(PasswordCredentials::class)
            setUrl(
                if (!isSnapshot)
                    "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2"
                else
                    "https://s01.oss.sonatype.org/content/repositories/snapshots"
            )
        }
        maven {
            name = "SoloStudiosSnapshots"

            url = uri("https://maven.solo-studios.ca/snapshots/")

            credentials(PasswordCredentials::class)
            authentication { // publishing doesn't work without this for some reason
                create<BasicAuthentication>("basic")
            }
        }
    }

    publications {
        register<MavenPublication>(project.name) {
            // publish main jars
            from(components["java"])
            // also publish dev jar
            artifact(tasks.jar)

            this.groupId = project.group.toString()
            this.artifactId = project.name
            this.version = rootProject.version.toString()

            pom {
                name.set(project.name)
                description.set(project.description)

                developers {
                    authors.forEach {
                        developer {
                            name.set(it)
                        }
                    }
                }

                licenses {
                    license {
                        name.set("GNU General Public License 3")
                        url.set("https://www.gnu.org/licenses/gpl-3.0.txt")
                    }
                }

                url.set("https://github.com/${githubRepo}")

                scm {
                    connection.set("scm:git:git://github.com/${githubRepo}.git")
                    url.set("https://github.com/${githubRepo}/tree/main")
                }
            }
        }
    }
}

signing {
    // Allow specifying the key, key id, and password via environment variables.
    val signingKey: String? by project
    val signingKeyId: String? by project
    val signingPassword: String? by project

    when {
        signingKey != null && signingKeyId != null && signingPassword != null -> {
            useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
        }

        signingKey != null && signingPassword != null -> {
            useInMemoryPgpKeys(signingKey, signingPassword)
        }

        else -> useGpgCmd()
    }
    sign(publishing.publications)
}
