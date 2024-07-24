# Demo WASM Android

This demo is an Android application that runs a WASM script through [Chicory runtime](https://github.com/dylibso/chicory).
In particular, this demo utilizes [Extism](https://github.com/extism) to simplify the communication between the host and the runtime.

## Extism SDK
At the moment, the [official Extism SDK for Chicory](https://github.com/extism/chicory-sdk) must be tweaked to run properly on Android, so [this fork](https://github.com/muneale/chicory-sdk) has the necessary things to make it work properly.
If you want to use the code from the official repository, go on `build.gradle.kts` file and change from
```
//    implementation("com.github.extism:chicory-sdk:main-SNAPSHOT")
      implementation("com.github.muneale:chicory-sdk:main-SNAPSHOT")
```
to
```
      implementation("com.github.extism:chicory-sdk:main-SNAPSHOT")
//    implementation("com.github.muneale:chicory-sdk:main-SNAPSHOT")
```
