package com.jssdvv.afi.directory.domain.repositories

import io.ktor.client.statement.HttpResponse

interface HttpRepository {
    suspend fun httpGetRequest(url: String): HttpResponse
}