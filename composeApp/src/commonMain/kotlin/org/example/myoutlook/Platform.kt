package org.example.myoutlook

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect  fun sendMessage(): String