package org.example.myoutlook

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()
actual fun sendMessage(): String {
    return  "Message sent from Web with Kotlin/Wasm"
}