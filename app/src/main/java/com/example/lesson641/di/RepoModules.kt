package com.example.lesson641.di

import com.example.lesson641.ui.Repository
import org.koin.core.module.Module
import  org.koin.dsl.module

val RepoModules: Module = module {
    single {
        Repository(get())
    }
}