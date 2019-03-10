package com.example.android.playapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView

class RecyclerViewTest : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT : String = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val totalCount = intent.getIntExtra(TOTAL_COUNT, 0)
        findViewById<TextView>(R.id.heading).text = getString(R.string.all_numbers_between_0_to_1d, totalCount)
        val list: MutableList<Int> = mutableListOf()
        for (i in 0..totalCount){
            list.add(i, i)
        }
        val recyclerViewTest: RecyclerView = findViewById(R.id.test_recycler_view)
        recyclerViewTest.adapter = RecyclerViewTestAdapter(list, this)
    }
}
