package com.example.interntasks_4a.Service

import com.example.interntasks_4a.Model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET

interface CharacterAPI {
    //https://potterapi-fedeperin.vercel.app/en/characters
    @GET("en/characters")
    suspend fun getCharacter() : Response<List<CharacterModel>>
}