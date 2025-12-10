plugins {
    id("net.labymod.labygradle")
    id("net.labymod.labygradle.addon")
}

val versions = providers.gradleProperty("net.labymod.minecraft-versions").get().split(";")

group = "de.raik"
version = providers.environmentVariable("VERSION").getOrElse("1.0.1")

labyMod {
    defaultPackageName = "de.raik.tnttimer"

    addonInfo {
        namespace = "tnttimer"
        displayName = "TNT Timer"
        author = "Sk1er LLC (port by Raik)"
        description = "Displays the time until a tnt detonates above the block"
        minecraftVersion = "*"
        version = rootProject.version.toString()
    }

    minecraft {
        registerVersion(versions.toTypedArray()) {
            runs {
                getByName("client") {
                    devLogin = true
                }
            }
        }
    }
}

subprojects {
    plugins.apply("net.labymod.labygradle")
    plugins.apply("net.labymod.labygradle.addon")

    group = rootProject.group
    version = rootProject.version
}
