package com.example.lesson641.ui.playlist_detail

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson641.R
import com.example.lesson641.extension.inflate
import com.example.lesson641.extension.loadImage
import com.example.lesson641.model.Items
import kotlinx.android.synthetic.main.playlist_detail_item.view.*

class PlayListDetailAdapter(
    private val list: MutableList<Items> = mutableListOf(),
    private val onHolderClick: (item: Items) -> Unit
) : RecyclerView.Adapter<PlayListDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListDetailViewHolder {
        return PlayListDetailViewHolder(parent.inflate(R.layout.playlist_detail_item))
    }

    override fun onBindViewHolder(holder: PlayListDetailViewHolder, position: Int) {
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

class PlayListDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(item: Items) {
        itemView.tv_name_rv_playlist_menu.text = item.snippet.title
        itemView.img_view_rv_playlist_menu.loadImage(item.snippet.thumbnails.default.url)
        itemView.tv_time_rv_playlist_menu.text =
            item.contentDetails.videoPublishedAt?.let { String.format(it) }
    }
}
