package com.jssdvv.afi.directory.data.repositories

import com.jssdvv.afi.directory.domain.repositories.HttpRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class HttpRepositoryImpl : HttpRepository {
    private val client = HttpClient()

    override suspend fun httpGetRequest(url: String): HttpResponse {
        return client.get(url)
    }
}