package com.example.lesson641.model

import com.google.gson.annotations.SerializedName

data class PlayList(
    @SerializedName("id") var id: Int,
    @SerializedName("kind") var kind: String?,
    @SerializedName("items") var items: List<String>
)