package com.example.lesson641.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesson641.BuildConfig.API_KEY
import com.example.lesson641.`object`.Constants
import com.example.lesson641.base.BaseViewModel
import com.example.lesson641.model.PlayList
import com.example.lesson641.network.RetrofitClient
import com.example.lesson641.network.YoutubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    private var youtubeApi: YoutubeApi = RetrofitClient.create()

    fun fetchAllPlayList(): LiveData<PlayList?> {
        return fetchYoutubeApiPlayList()
    }

    private fun fetchYoutubeApiPlayList(): LiveData<PlayList?> {
        val data = MutableLiveData<PlayList?>()
        youtubeApi.fetchAllPlayList(Constants.PART, Constants.CHANEL_ID, API_KEY)
            .enqueue(object : Callback<PlayList> {
                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    //404 - не найдено, 403 - токен истек, 401 - нет доступа
                }

            })
        return data
    }
}