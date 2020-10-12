package com.example.testapi.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://base_url_here/"
const val EXTRA_S = "extra/string/layers/if/needed/productid?api="
private const val API_KEY = "your_api_key"
const val QUERY_S = EXTRA_S + API_KEY


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET(QUERY_S)
    fun getIt():
            Call<String>
}

object Api {
    val retrofitService : ApiService by lazy { retrofit.create(ApiService::class.java) }
}
