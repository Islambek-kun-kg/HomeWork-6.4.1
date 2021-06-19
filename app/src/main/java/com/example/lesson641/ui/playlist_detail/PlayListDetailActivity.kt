package com.example.lesson641.ui.playlist_detail

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson641.R
import com.example.lesson641.`object`.Constants
import com.example.lesson641.core.base.BaseActivity
import com.example.lesson641.model.Items
import com.example.lesson641.core.network.result.Status
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.rv_playlist
import kotlinx.android.synthetic.main.activity_play_list_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListDetailActivity : BaseActivity(R.layout.activity_play_list_detail) {

    private val list = mutableListOf<Items>()
    private var playListDetailAdapter: PlayListDetailAdapter? = null
    private val viewModel: PlayListDetailViewModel by viewModel()

    override fun setupUI() {
    }

    override fun setupLiveData() {
        viewModel.fetchItemPlayList(intent.getStringExtra(Constants.KEY_ID).toString())
            .observe(this, { response ->
                when (response?.status) {
                    Status.SUCCESS -> {
                        response.data?.items?.let { it.let { list.addAll(it) } }
                        setupRecyclerView()
                        textTitle.text = intent.getStringExtra(Constants.KEY_TITLE).toString()
                        textDescription.text = response.data?.items?.get(0)?.snippet?.description
                        count_rv_playlist.text =
                            String.format(
                                "${response.data?.pageInfo?.totalResults}${
                                    " " + getString(
                                        R.string.video_series
                                    )
                                }"
                            )
                        playListDetailAdapter?.notifyDataSetChanged()
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

    override fun showDisconnectState() {
    }

    private fun setupRecyclerView() {
        playListDetailAdapter = PlayListDetailAdapter(list, this::onHolderClick)
        rv_playlist.apply {
            layoutManager = LinearLayoutManager(this@PlayListDetailActivity)
            adapter = playListDetailAdapter
        }
    }

    private fun onHolderClick(item: Items) {
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
    }
}