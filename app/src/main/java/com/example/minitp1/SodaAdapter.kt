package com.example.minitp1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp1.databinding.ItemCustomRecyclerBinding
import com.example.minitp1.model.SodaPojo

private val diffItemUtils = object : DiffUtil.ItemCallback<SodaPojo>() {


    override fun areItemsTheSame(oldItem: SodaPojo, newItem: SodaPojo): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: SodaPojo, newItem: SodaPojo): Boolean {
        return oldItem == newItem
    }
}

class SodaAdapter : ListAdapter<SodaPojo, SodaViewHolder>(diffItemUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SodaViewHolder {
        return SodaViewHolder(
            ItemCustomRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: SodaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }



}

class SodaViewHolder(
    private val binding: ItemCustomRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(SodaPojo: SodaPojo) {
        binding.itemRecyclerViewVersionName.text = SodaPojo.sodaName
        binding.itemRecyclerViewVersionCode.text = "${SodaPojo.sodaSugarGramme}"
    }
}
