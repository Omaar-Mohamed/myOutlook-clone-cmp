package org.example.myoutlook.data.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(val address: String, val password: String)

