package com.example.lesson641.data.remote

import com.example.lesson641.model.PlayList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    suspend fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int,
        @Query("key") apiKey: String
    ): Response<PlayList>

    @GET("playlistItems")
    suspend fun fetchAllPlaylistItems(
        @Query("part") part: String,
        @Query("maxResults") maxResults: Int,
        @Query("playlistId") playlistId: String,
        @Query("key") apiKey: String
    ): Response<PlayList>


}