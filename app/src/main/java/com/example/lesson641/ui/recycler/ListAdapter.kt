package com.example.lesson641.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson641.R
import com.example.lesson641.model.PlayList
import kotlinx.android.synthetic.main.activity_main.view.*

class ListAdapter(
    private val playList: PlayList,
    private val list: MutableList<PlayList> = mutableListOf(),
    private val listener: ItemClickListener
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = list.size
}