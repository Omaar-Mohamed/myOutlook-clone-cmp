package org.example.myoutlook.data.remoteDataSourse

interface MailTmApi {
    suspend fun register(email: String, password: String)
    suspend fun login(email: String, password: String): String
}