package com.example.lesson641.di

import com.example.lesson641.ui.main.MainViewModel
import com.example.lesson641.ui.playlist_detail.PlayListDetailViewModel
import org.koin.core.module.Module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModules: Module = module {
    viewModel {
        MainViewModel(get())
    }
    viewModel {
        PlayListDetailViewModel(get())
    }
}