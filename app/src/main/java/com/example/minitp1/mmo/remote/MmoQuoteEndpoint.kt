package com.example.minitp1.mmo.remote

import com.example.minitp1.mmo.model.MmoRetrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface MmoQuoteEndpoint {


    @GET("game")
    suspend fun getRandomQuote(@Query(value = "id", encoded = true) gameId: String) : MmoRetrofit
}
