package com.example.ozinshe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MainImageAdapter(private val images: List<Pair<Int, Int>>) : RecyclerView.Adapter<MainImageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1: ImageView = itemView.findViewById(R.id.ivAdapter1)
        val imageView2: ImageView = itemView.findViewById(R.id.ivAdapter2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_page, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (image1, image2) = images[position]
        holder.imageView1.setImageResource(image1)
        holder.imageView2.setImageResource(image2)
    }

    override fun getItemCount(): Int = images.size
}