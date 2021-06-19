package com.example.lesson641.ui.playlist_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lesson641.core.network.result.Resource
import com.example.lesson641.core.base.BaseViewModel
import com.example.lesson641.model.PlayList
import com.example.lesson641.ui.Repository

class PlayListDetailViewModel(private val repository: Repository) : BaseViewModel() {

    val loading = MutableLiveData<Boolean>()

    fun fetchItemPlayList(id: String): LiveData<Resource<PlayList>> {
        return repository.fetchDetailPlaylist(id)
    }

}