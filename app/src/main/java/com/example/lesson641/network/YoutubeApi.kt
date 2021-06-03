package com.example.lesson641.network

import com.example.lesson641.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("/playlists")
    fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("chanelId") chanelId: String,
        @Query("key") apiKey: String
    ): Call<PlayList>


}