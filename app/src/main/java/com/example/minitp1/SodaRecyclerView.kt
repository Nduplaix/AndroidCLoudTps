package com.example.minitp1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp1.databinding.ActivityRecyclerViewBinding
import com.example.minitp1.model.SodaPojo

class SodaRecyclerView: AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: SodaAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Create the instance of adapter
        adapter = SodaAdapter()


        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter


        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())
    }


    private fun generateFakeData(): ArrayList<SodaPojo> {
        return arrayListOf(
            SodaPojo("Coca-cola", 39.0),
            SodaPojo("Fanta", 38.0),
            SodaPojo("Orangina", 38.0),
            SodaPojo("Ice Tea", 40.0),
            SodaPojo("FuzeTea", 35.0),
            SodaPojo("Dr. Pepper", 36.0),
            SodaPojo("Pepsi", 41.0),
            SodaPojo("Sprite", 38.0)
        )
    }
}