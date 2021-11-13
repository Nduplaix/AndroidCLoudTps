package com.example.minitp1.architecture

import com.example.minitp1.mmo.remote.MmoQuoteEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.mmobomb.com/api1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()


    fun getMmoQuote(): MmoQuoteEndpoint = retrofit.create(MmoQuoteEndpoint::class.java)
}
