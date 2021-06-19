package com.example.lesson641.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.lesson641.BuildConfig
import com.example.lesson641.`object`.Constants
import com.example.lesson641.model.PlayList
import com.example.lesson641.data.remote.YoutubeApi
import com.example.lesson641.core.network.result.Resource
import com.example.lesson641.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {

    fun fetchYoutubeApiPlayList(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(dataSource.fetchAllPlayLists())
    }

    fun fetchDetailPlaylist(id: String): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        emit(dataSource.fetchAllPlaylistItem(id))
    }
}