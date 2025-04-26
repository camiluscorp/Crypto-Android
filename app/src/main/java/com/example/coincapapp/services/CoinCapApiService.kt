package com.example.coincapapp.services

import com.example.coincapapp.models.AssetsResponse
import javax.inject.Inject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class CoinCapApiService @Inject constructor (
    private val client: HttpClient
) {
    suspend fun  getAssets(): AssetsResponse {
        val response: HttpResponse = client.get(urlString = "https://a27c2c52-aa18-451d-8b25-24fc7448c9f7.mock.pstmn.io/v3/assets")
        //val response: HttpResponse = client.get(urlString = "https://rest.coincap.io/v3/assets?apiKey=0e46f6021931e3999ce3675a3548da6eb0a895d3328a5c3cbdcc17e846dafc42")
        return response.body()
    }
}