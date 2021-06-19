package com.example.lesson641.ui.main

import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson641.R
import com.example.lesson641.`object`.Constants
import com.example.lesson641.core.base.BaseActivity
import com.example.lesson641.extension.visible
import com.example.lesson641.model.Items
import com.example.lesson641.core.network.result.Status
import com.example.lesson641.ui.playlist_detail.PlayListDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main) {
    private val list = mutableListOf<Items>()
    private val mainAdapter: MainAdapter? by lazy { MainAdapter(list, this::onHolderClick) }
    private val viewModel: MainViewModel by viewModel()

    override fun setupUI() {

    }

    override fun setupLiveData() {

        viewModel.setBoolean(true)

        viewModel.loading.observe(this, {
            progress_bar.visible = it
        })

        viewModel.fetchAllPlayList.observe(this, { response ->
            when (response?.status) {
                Status.SUCCESS -> {
                    response.data?.items?.let { it.let { list.addAll(it) } }
                    setupRecyclerView()
                    mainAdapter?.notifyDataSetChanged()
                    viewModel.loading.postValue(false)
                }
                Status.ERROR -> {
                    viewModel.loading.postValue(false)
                    Toast.makeText(this, response.code.toString(), Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> viewModel.loading.postValue(true)
            }
        })
    }

    override fun showDisconnectState() {}

    private fun setupRecyclerView() {
        rv_playlist.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }

    private fun onHolderClick(item: Items) {
        val intent = Intent(this, PlayListDetailActivity::class.java)
        intent.putExtra(Constants.KEY_ID, item.id)
        intent.putExtra(Constants.KEY_TITLE,item.snippet.title)
        intent.putExtra(Constants.KEY_DESC,item.snippet.description)
        intent.putExtra(Constants.KEY_COUNT,item.contentDetails.itemCount)
        startActivity(intent)
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
    }
}