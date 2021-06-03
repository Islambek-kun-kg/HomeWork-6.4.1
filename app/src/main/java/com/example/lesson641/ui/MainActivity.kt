package com.example.lesson641.ui

import android.widget.ListAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.lesson641.R
import com.example.lesson641.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {
    private var adapter: ListAdapter? = null
    private var viewModel: MainViewModel? = null

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun setupLiveData() {
        viewModel?.fetchAllPlayList()?.observe(this, {
            Toast.makeText(this, it?.kind.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    override fun showDisconnectState() {

    }

}