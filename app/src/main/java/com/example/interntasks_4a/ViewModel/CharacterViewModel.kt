package com.example.interntasks_4a.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interntasks_4a.Model.CharacterModel
import com.example.interntasks_4a.Service.CharacterAPI
import com.example.interntasks_4a.Service.CharacterAPIService
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel (){

    private val characterAPI: CharacterAPI = CharacterAPIService.getCharacterAPI()
    val characters = MutableLiveData<List<CharacterModel>>()
    val error = MutableLiveData<String>()

    fun getData() {
        viewModelScope.launch {
            try {
                val response = characterAPI.getCharacter()
                if (response.isSuccessful) {
                    characters.value = response.body()
                } else {
                    error.value = "Error: ${response.message()}"
                }
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }
}