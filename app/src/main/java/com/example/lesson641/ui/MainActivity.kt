package com.example.lesson641.ui

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson641.R
import com.example.lesson641.base.BaseActivity
import com.example.lesson641.model.Items
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main), ItemClickListener {
    private val list = mutableListOf<Items>()
    private var mainAdapter: MainAdapter? = null
    private var viewModel: MainViewModel? = null

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun setupLiveData() {
        viewModel?.fetchAllPlayList()?.observe(this, { response ->
            response?.items?.let { list.addAll(it) }
            setupRecyclerView()
            mainAdapter?.notifyDataSetChanged()
        })
    }

    override fun showDisconnectState() {}

    private fun setupRecyclerView() {
        mainAdapter = MainAdapter(list, this)
        rv_playlist.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }

    override fun onItemClick(item: Items) {
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
    }

}