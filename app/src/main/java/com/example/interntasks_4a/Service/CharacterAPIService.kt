package com.example.interntasks_4a.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterAPIService {
    private val BASE_URL = "https://potterapi-fedeperin.vercel.app/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getCharacterAPI(): CharacterAPI {
        return retrofit.create(CharacterAPI::class.java)
    }
}