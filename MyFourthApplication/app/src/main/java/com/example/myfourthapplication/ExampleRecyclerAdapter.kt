package com.example.myfourthapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfourthapplication.data.MemesResponse
import com.example.myfourthapplication.databinding.ExampleAdapterBinding

class ExampleRecyclerAdapter(): RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>() {

    val adapterList = mutableListOf<MemesResponse.Data.Meme>()

    inner class ExampleViewHolder(private val binding: ExampleAdapterBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(itemMemes: MemesResponse.Data.Meme){
            binding.tvProduct.text = itemMemes.name
            Glide.with(binding.imageView.context)
                .load(itemMemes.url)
                .into(binding.imageView)
        }
    }

    fun submitList(list: List<MemesResponse.Data.Meme>) {
        adapterList.clear()
        adapterList.addAll(list.shuffled())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleRecyclerAdapter.ExampleViewHolder {
        return ExampleViewHolder(ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ExampleRecyclerAdapter.ExampleViewHolder, position: Int) {
        holder.onBind(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }
}