package com.example.lesson641.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setupUI()
        setupLiveData()
        showDisconnectState()
    }

    abstract fun setupUI()  // внутри этого метода мы инициализируем все view

    abstract fun setupLiveData()    // внутри этого метода мы инициализируем все live data

    abstract fun showDisconnectState()  // метод который отображает подключение к интернету
}