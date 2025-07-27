package org.example.myoutlook.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TokenRequest(val address: String, val password: String)
