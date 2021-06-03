package com.example.lesson641.ui.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson641.model.PlayList
import kotlinx.android.synthetic.main.playlist_item.view.*

open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var listener: ItemClickListener? = null
    fun onBind(item: PlayList) {
        itemView.tv_count_rv_playlist.text = item.kind
        itemView.setOnClickListener {
            listener?.onItemClick(adapterPosition, item)
        }
    }
}

interface ItemClickListener {
    fun onItemClick(position: Int, item: PlayList)
}