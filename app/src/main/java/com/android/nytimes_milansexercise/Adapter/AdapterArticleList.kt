package com.android.nytimes_milansexercise.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.nytimes_milansexercise.Data.DataArticle
import com.android.nytimes_milansexercise.R
import com.android.nytimes_milansexercise.Utility.inflateLayout
import com.bumptech.glide.Glide

class AdapterArticleList(
    var context: Context,
    var list: List<DataArticle.Result>?,
    val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<AdapterArticleList.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        return Holder(viewGroup.inflateLayout(R.layout.item_article))
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = list!!.get(position).title
        holder.detail_item.text = list!!.get(position).abstract
        if (list!!.get(position).media.size > 0)
            Glide.with(context).load(list!!.get(position).media.get(0).media_metadata.get(2).url)
                .into(holder.img_item_articles)
        holder.itemView.setOnClickListener {
            clickListener(position)
        }
    }

    inner class Holder(v: View) : RecyclerView.ViewHolder(v) {
        var title: TextView = itemView.findViewById(R.id.title)
        var detail_item: TextView = itemView.findViewById(R.id.detail_item)
        var img_item_articles: ImageView = itemView.findViewById(R.id.img_item_articles)
    }
}