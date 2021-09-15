package com.example.minitp1

import android.os.Bundle
import android.util.Log
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp1.databinding.ActivityRecyclerViewBinding
import com.example.minitp1.model.SodaFooterSample
import com.example.minitp1.model.SodaHeaderSample
import com.example.minitp1.model.SodaObjectForRecycleView
import com.example.minitp1.model.SodaPojo

class SodaRecyclerView: AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: SodaAdapter
    private var result = mutableListOf<SodaObjectForRecycleView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Create the instance of adapter
        adapter = SodaAdapter{ item, view ->
            onItemClick(item, view)
        }



        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = adapter


        // Generate data and give it to adapter
        adapter.submitList(generateFakeData())
    }


    private fun generateFakeData(): MutableList<SodaObjectForRecycleView> {
        result = mutableListOf<SodaObjectForRecycleView>()
        val fruitsSoda =  arrayListOf<String>("Fanta", "Orangina", "Ice Tea", "FuzeTea")
        mutableListOf(
            SodaPojo(0,"Coca-cola", 39.0, false),
            SodaPojo(1,"Fanta", 38.0, false),
            SodaPojo(2, "Orangina", 38.0, false),
            SodaPojo(3, "Ice Tea", 40.0, false),
            SodaPojo(4, "FuzeTea", 35.0, false),
            SodaPojo(5, "Dr. Pepper", 36.0, false),
            SodaPojo(6, "Pepsi", 41.0, false),
            SodaPojo(7, "Sprite", 38.0, false)
        ).groupBy {
            // Split in 2 list, modulo and not
            fruitsSoda.contains(it.sodaName)
        }.forEach { (isFruitsSoda, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            result.add(SodaHeaderSample(0,
                if (isFruitsSoda) "Soda \"with Fruits\"" else "Soda without fruits"
            ))
            result.addAll(items)
            result.add(SodaFooterSample(0,"Soda numbers : ${items.size}"))
        }

        return result
    }

    private fun onItemClick(objectDataSample: SodaPojo, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        objectDataSample.isFavorite = !objectDataSample.isFavorite
        val index = result.indexOf(objectDataSample)

        result.set(index, objectDataSample)

        adapter.submitList(result)

        Toast.makeText(this, objectDataSample.sodaName, Toast.LENGTH_SHORT).show()
    }

}