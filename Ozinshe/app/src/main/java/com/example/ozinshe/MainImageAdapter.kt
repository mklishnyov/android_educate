package com.example.ozinshe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainImageAdapter(private val image: List<Int>, private val text: List<String>) : RecyclerView.Adapter<MainImageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1: ImageView = itemView.findViewById(R.id.ivAdapter1)
        val textView1: TextView = itemView.findViewById(R.id.textView4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_page, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image1 = image[position]
        holder.imageView1.setImageResource(image1)

        val text1 = text[position]
        holder.textView1.text = text1
    }

    override fun getItemCount(): Int = image.size
}