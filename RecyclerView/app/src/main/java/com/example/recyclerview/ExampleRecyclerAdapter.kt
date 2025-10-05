package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ExampleAdapterBinding

class ExampleRecyclerAdapter(): RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>() {

    private var adapterList = mutableListOf<Product>()

    inner class ExampleViewHolder(private var binding: ExampleAdapterBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Product) {
            binding.tvProductTitle.text = item.title
            binding.tvProductPrice.text = item.price.toString()
        }
    }

    fun submit(list: List<Product>){
        adapterList.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleRecyclerAdapter.ExampleViewHolder {
        return ExampleViewHolder(
            ExampleAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ExampleRecyclerAdapter.ExampleViewHolder,
        position: Int
    ) {
        holder.onBind(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }
}