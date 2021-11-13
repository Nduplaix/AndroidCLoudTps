package com.example.minitp1.mmo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp1.mmo.model.MmoUi
import com.example.minitp1.mmo.viewModel.MmoViewModel
import com.example.minitp1.databinding.ActivityMmoBinding

class MmoActivity : AppCompatActivity() {
    private lateinit var viewModel: MmoViewModel
    private lateinit var binding : ActivityMmoBinding
    private val adapter : MmoAdapter = MmoAdapter()
    private val observer = Observer<List<MmoUi>> {
        adapter.submitList(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMmoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MmoViewModel::class.java]


        binding.mmoActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.mmoActivityRv.adapter = adapter


        binding.mmoActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }


        binding.mmoActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }
    override fun onStart() {
        super.onStart()
        viewModel.mMmoQuoteLiveData.observe(this, observer)
    }


    override fun onStop() {
        viewModel.mMmoQuoteLiveData.removeObserver(observer)
        super.onStop()
    }
}
