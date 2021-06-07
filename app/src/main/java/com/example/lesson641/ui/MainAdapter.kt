package com.example.lesson641.ui

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
    private val listener: ItemClickListener
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.playlist_item), listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class ViewHolder(itemView: View, private val listener: ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun onBind(item: Items) {
        itemView.img_view_rv_playlist.loadImage(item.snippet.thumbnails.default.url)
        itemView.tv_title_rv_playlist.text = item.snippet.title
        itemView.tv_count_rv_playlist.text =
            item.contentDetails.itemCount.toString() + " video series"
//            item.contentDetails.videoPublishedAt?.let { String.format(it) }
        itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }
}

interface ItemClickListener {
    fun onItemClick(item: Items)
}