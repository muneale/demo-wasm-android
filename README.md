# Demo WASM Android
This demo showcases an Android app that executes a WASM script using the [Chicory runtime](https://github.com/dylibso/chicory). Specifically, this demonstration employs [Extism](https://github.com/extism) to streamline the interaction between the host and the runtime.

## Extism SDK
This demo is using the [official Extism SDK for Chicory](https://github.com/extism/chicory-sdk).

## WASM Plugins
The plugin `greet.wasm` has been downloaded from the official Extism's plugins repository.

If you want to use a different plugin:
1. Download another one from the [official plugins repository](https://github.com/extism/plugins/).
2. Add the wasm file into the `assets` folder.
3. Change the function `runGreetings()` on `MainActivity.kt` according with the plugin's input/output/function_name.

To build your own script, please take a look at the [official Extism documentation](https://extism.org/docs/concepts/pdk).
