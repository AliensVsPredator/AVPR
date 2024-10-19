[curse-downloads-shield]: https://img.shields.io/curseforge/dt/1005026
[curse-files-url]: https://www.curseforge.com/minecraft/mc-mods/avp-regenesis/files

[curse-versions-shield]: https://img.shields.io/curseforge/game-versions/1005026
[curse-url]: https://www.curseforge.com/minecraft/mc-mods/avp-regenesis

[modrinth-downloads-shield]: https://img.shields.io/modrinth/dt/Uqo0H9FX
[modrinth-files-url]: https://modrinth.com/mod/avp-regenesis/versions/files

[modrinth-versions-shield]: https://img.shields.io/modrinth/game-versions/Uqo0H9FX
[modrinth-url]: https://modrinth.com/mod/avp-regenesis

[discord-shield]: https://dcbadge.limes.pink/api/server/https://discord.gg/wp7mvmbkVb
[discord-url]: https://discord.gg/wp7mvmbkVb

[github-build]: https://github.com/AliensVsPredator/AVP-Regenesis/actions/workflows/build.yml/badge.svg
[github-build-url]:https://github.com/AliensVsPredator/AVP-Regenesis/actions/workflows/build.yml

[java-shield]: https://img.shields.io/badge/Made%20with-Java-ED8B00.svg
[java-url]: https://www.java.com/

[license-shield]: https://img.shields.io/badge/License-MIT-green.svg
[license-url]: https://opensource.org/licenses/MIT

[IntelliJ IDEA]: https://www.jetbrains.com/idea/
[Gradle]: https://www.gradle.org/
[Java Development Kit 21]: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[CurseForge]: https://preview.redd.it/i-heard-that-curseforge-rebranded-their-logo-is-it-good-or-v0-hualodaes7ka1.png?auto=webp&s=985d21b6461a7e0be2dfb5d4e3beb64401711c9e

AVP: Regenesis
=============
[![github-build]][github-build-url]
[![license-shield]][license-url]
[![java-shield]][java-url]
[![discord-shield]][discord-url]

<img src="https://i.imgur.com/L6vA521.png" alt="CurseForge" width="200"/>

[![curse-versions-shield]][curse-url]
[![curse-downloads-shield]][curse-files-url]

<img src="https://crowdin-static.downloads.crowdin.com/images/project-logo/518556/small/d0d0fa84ec9d7863f8ce01c6a4352272374.png" alt="Modrinth" width="200"/>

[![modrinth-versions-shield]][modrinth-url]
[![modrinth-downloads-shield]][modrinth-files-url]

## Prerequisites ##
* [Java Development Kit 21]
* [Gradle]

## Contributing ##
Before contributing to this project, please ensure that you read the following guidelines. It's crucial to have your development environment configured correctly. Additionally, pull requests that do not adhere to the specified format will not be accepted.

### 1) Clone The Repository ###
Follow the steps here: https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository

### 2) Setup in [IntelliJ IDEA] ###
1. Open the template's root folder as a new project in IDEA. This is the folder that contains this README.md file and the gradlew executable.
2. If your default JVM/JDK is not Java 21 you will encounter an error when opening the project. This error is fixed by going to `File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JVM` and changing the value to a valid Java 21 JVM. You will also need to set the Project SDK to Java 21. This can be done by going to `File > Project Structure > Project SDK`. Once both have been set open the Gradle tab in IDEA and click the refresh button to reload the project.
3. Open your Run/Debug Configurations. Under the `Application` category there should now be options to run Fabric and NeoForge projects. Select one of the client options and try to run it.
4. Assuming you were able to run the game in step 3 your workspace should now be set up.

__**Eclipse/VSCode not supported**__

### 3) Creating a PR ###
Please do at least one build via `Tasks > build > build` to have the spotless plugin format all code before submitting the PR.

Follow the steps here: https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request
