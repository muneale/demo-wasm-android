package com.example.demowasmandroid

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demowasmandroid.ui.theme.DemoWasmAndroidTheme
import org.extism.chicory.sdk.Manifest
import org.extism.chicory.sdk.Plugin
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    private fun runGreetings(wasmData: ByteArray, name: String) : String {
        Log.d(TAG, "Start runGreetings with name '$name'")
        val manifest: Manifest = Manifest.fromBytes(wasmData)
        val plugin = Plugin(manifest, arrayOf(), LoggerBridge("ChicoryRuntime"))
        val result = String(
            plugin.call("greet", name.toByteArray(StandardCharsets.UTF_8)),
            StandardCharsets.UTF_8
        )
        Log.d(TAG, "Result from runGreetings: $result")
        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val btn: Button = findViewById(R.id.runButton)
        val textView: TextView = findViewById(R.id.greetingsTextView)

        btn.setOnClickListener {
            val wasmFile = assets.open("greet.wasm")
            val size: Int = wasmFile.available()
            val buffer = ByteArray(size)
            wasmFile.read(buffer)
            wasmFile.close()

            val greetings = runGreetings(buffer, nameEditText.text.toString())
            textView.text = greetings
        }
    }
}
