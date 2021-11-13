package com.example.minitp1.mmo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.minitp1.mmo.model.MmoUi
import com.example.minitp1.databinding.ItemMmoBinding

val diffUtils = object : DiffUtil.ItemCallback<MmoUi>() {
    override fun areItemsTheSame(oldItem: MmoUi, newItem: MmoUi): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: MmoUi, newItem: MmoUi): Boolean {
        return oldItem == newItem
    }
}

class MmoQuoteViewHolder(
    val binding: ItemMmoBinding
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var ui: MmoUi


    fun bind(mmoUi: MmoUi) {
        ui = mmoUi
        Glide.with(itemView.context)
            .load(mmoUi.thumbnail)
            .into(binding.itemMmoIcon)


        binding.itemMmoQuote.text = mmoUi.short_description
    }
}

class MmoAdapter : ListAdapter<MmoUi, MmoQuoteViewHolder>(diffUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MmoQuoteViewHolder {
        return MmoQuoteViewHolder(
            ItemMmoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: MmoQuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
