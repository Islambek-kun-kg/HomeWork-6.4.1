package com.example.lesson641.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.lesson641.core.base.BaseViewModel
import com.example.lesson641.model.PlayList
import com.example.lesson641.core.network.result.Resource
import com.example.lesson641.ui.Repository

class MainViewModel(private val repository: Repository) : BaseViewModel() {


    val loading = MutableLiveData<Boolean>()
    private val _fetchAllPlayList = MutableLiveData<Boolean>()

    val fetchAllPlayList: LiveData<Resource<PlayList>> = _fetchAllPlayList.switchMap {
        repository.fetchYoutubeApiPlayList()
    }

    fun setBoolean(isPlayList: Boolean) {
        _fetchAllPlayList.postValue(isPlayList)
    }
}