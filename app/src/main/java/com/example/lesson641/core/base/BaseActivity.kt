package com.example.lesson641.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson641.utils.connectionCheck.ConnectChecker

abstract class BaseActivity(private val layout: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setupUI()
        setupLiveData()
        showDisconnectState()
    }

    override fun onResume() {
        super.onResume()
    }

    abstract fun setupUI()  // внутри этого метода мы инициализируем все view

    abstract fun setupLiveData()    // внутри этого метода мы инициализируем все live data

    abstract fun showDisconnectState()  // метод который отображает подключение к интернету
}