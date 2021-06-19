package com.example.lesson641.di

import com.example.lesson641.core.network.NetworkModule
import com.example.lesson641.data.remote.RemoteDataSourceModule

val KoinModules = listOf(
    ViewModules,
    RepoModules,
    NetworkModule,
    RemoteDataSourceModule
)