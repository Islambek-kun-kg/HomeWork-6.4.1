package com.example.lesson641.data.remote

import com.example.lesson641.BuildConfig
import com.example.lesson641.`object`.Constants
import com.example.lesson641.core.network.BaseDataSource
import org.koin.dsl.module


val RemoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiServ: YoutubeApi) : BaseDataSource() {

    suspend fun fetchAllPlayLists() = getResult {
        apiServ.fetchAllPlayList(
            Constants.PART,
            Constants.CHANNEL_ID,
            Constants.MAX_RESULTS,
            BuildConfig.API_KEY
        )
    }

    suspend fun fetchAllPlaylistItem(id: String) = getResult {
        apiServ.fetchAllPlaylistItems(
            Constants.PART,
            Constants.MAX_RESULTS,
            id,
            BuildConfig.API_KEY
        )
    }

}