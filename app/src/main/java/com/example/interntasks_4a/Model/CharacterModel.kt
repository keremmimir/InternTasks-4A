package com.example.interntasks_4a.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterModel(
     val fullName : String?,
     val nickname : String?,
     val hogwartsHouse : String?,
     val interpretedBy : String?,
     val children : List<String>?,
     val image : String?,
     val birthdate : String?,
     val index : Int?
 ) : Parcelable
