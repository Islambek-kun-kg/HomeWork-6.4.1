package com.example.lesson641.ui.main

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson641.R
import com.example.lesson641.extension.inflate
import com.example.lesson641.extension.loadImage
import com.example.lesson641.model.Items
import kotlinx.android.synthetic.main.playlist_item.view.*

class MainAdapter(
    private val list: MutableList<Items> = mutableListOf(),
    val onHolderClick: (item: Items) -> Unit
) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(parent.inflate(R.layout.playlist_item))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            onHolderClick(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    fun submitList(items: MutableList<Items>) {
        val start = list.size - 1
        list.addAll(items)
        notifyItemRangeChanged(start, list.size - 1)
    }
}

class MainViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun onBind(item: Items) {
        itemView.img_view_rv_playlist.loadImage(item.snippet.thumbnails.default.url)
        itemView.tv_title_rv_playlist.text = item.snippet.title
        itemView.tv_count_rv_playlist.text =
            String.format("${item.contentDetails.itemCount} video series")
    }
}