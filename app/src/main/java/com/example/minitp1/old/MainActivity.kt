package com.example.minitp1.old

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.minitp1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickOpenSodaRecyclerView(view: View) {
        val intent = Intent(this, SodaRecyclerView::class.java)
        startActivity(intent)
    }
}