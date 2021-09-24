package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NewsAdapter(private val mList:List<NewsViewModel>,private val context:Context):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_design, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.tvTitle.text=ItemsViewModel.title
        holder.tvDesc.text=ItemsViewModel.description
        if (ItemsViewModel.image !== null) {

            Picasso.get().load(ItemsViewModel.image).into(holder.imageNews)
        }else{
            holder.imageNews.setImageResource(R.drawable.ic_launcher_background)

        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvTitle:TextView=itemView.findViewById(R.id.tv_title)
        val tvDesc:TextView=itemView.findViewById(R.id.tv_description)
        val imageNews:ImageView=itemView.findViewById(R.id.img_news)
    }

}