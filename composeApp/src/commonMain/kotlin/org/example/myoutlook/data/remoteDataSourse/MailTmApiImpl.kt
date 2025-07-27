package org.example.myoutlook.data.remoteDataSourse

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.example.myoutlook.data.models.RegisterRequest
import org.example.myoutlook.data.models.TokenRequest
import org.example.myoutlook.data.models.TokenResponse

class MailTmApiImpl(private val client: HttpClient) : MailTmApi {
    override suspend fun register(email: String, password: String) {
        client.post("https://api.mail.tm/accounts") {
            contentType(ContentType.Application.Json)
            setBody(RegisterRequest(email, password))
        }
    }

    override suspend fun login(email: String, password: String): String {
        val response: TokenResponse = client.post("https://api.mail.tm/token") {
            contentType(ContentType.Application.Json)
            setBody(TokenRequest(email, password))
        }.body()
        return response.token
    }
}