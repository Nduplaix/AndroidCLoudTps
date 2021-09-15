package com.example.minitp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp1.databinding.ItemCustomRecyclerBinding
import com.example.minitp1.databinding.ItemCustomRecyclerFooterBinding
import com.example.minitp1.databinding.ItemCustomRecyclerHeaderBinding
import com.example.minitp1.model.SodaFooterSample
import com.example.minitp1.model.SodaHeaderSample
import com.example.minitp1.model.SodaObjectForRecycleView
import com.example.minitp1.model.SodaPojo

private val diffItemUtils = object : DiffUtil.ItemCallback<SodaObjectForRecycleView>() {


    override fun areItemsTheSame(oldItem: SodaObjectForRecycleView, newItem: SodaObjectForRecycleView): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: SodaObjectForRecycleView, newItem: SodaObjectForRecycleView): Boolean {
        return oldItem == newItem
    }
}

class SodaAdapter(
    private val onItemClick: (quoteUi: SodaPojo, view: View) -> Unit,
):  ListAdapter<SodaObjectForRecycleView, RecyclerView.ViewHolder>(diffItemUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                SodaViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onItemClick
                )
            }



            MyItemType.HEADER.type -> {
                SodaHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            MyItemType.FOOTER.type -> {
                SodaFooterViewHolder(
                    ItemCustomRecyclerFooterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw RuntimeException("Wrong view type received $viewType")
        }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as SodaViewHolder).bind(getItem(position) as SodaPojo)
            MyItemType.HEADER.type -> (holder as SodaHeaderViewHolder).bind(getItem(position) as SodaHeaderSample)
            MyItemType.FOOTER.type -> (holder as SodaFooterViewHolder).bind(getItem(position) as SodaFooterSample)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is SodaPojo -> MyItemType.ROW.type
            is SodaHeaderSample -> MyItemType.HEADER.type
            is SodaFooterSample -> MyItemType.FOOTER.type
        }
    }



}

class SodaViewHolder(
    private val binding: ItemCustomRecyclerBinding,
    onItemClick: (objectDataSample: SodaPojo, view: View) -> Unit
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var ui: SodaPojo


    init {
        binding.root.setOnClickListener {
            onItemClick(ui, itemView)
        }
    }


    fun bind(objectDataSample: SodaPojo) {
        ui = objectDataSample
        binding.itemRecyclerViewVersionName.text = objectDataSample.sodaName
        binding.itemRecyclerViewVersionCode.text = "${objectDataSample.sodaSugarGramme}"
        binding.imageView.setImageResource(
            if(objectDataSample.isFavorite) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24
        )
    }
}



class SodaHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataHeaderSample: SodaHeaderSample) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
    }
}

class SodaFooterViewHolder(
    private val binding: ItemCustomRecyclerFooterBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(objectDataFooterSample: SodaFooterSample) {
        binding.itemRecyclerViewFooter.text = objectDataFooterSample.footer
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1),
    FOOTER(2)
}