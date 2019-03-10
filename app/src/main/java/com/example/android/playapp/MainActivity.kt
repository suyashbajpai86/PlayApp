package com.example.android.playapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var counterValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.random_button).setOnClickListener(this)
        findViewById<Button>(R.id.count_button).setOnClickListener(this)
        findViewById<Button>(R.id.toast_button).setOnClickListener(this)
        findViewById<Button>(R.id.list_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.toast_button -> {
                showToast()
            }

            R.id.count_button -> {
                incrementCount()
            }

            R.id.random_button -> {
                setRandomNumber()
            }

            R.id.list_button -> {
                openListOfNumbers()
            }
        }
    }

    private fun openListOfNumbers() {
        val recyclerActivity = Intent(this, RecyclerViewTest::class.java)
        recyclerActivity.putExtra(RecyclerViewTest.TOTAL_COUNT, counterValue)
        startActivity(recyclerActivity)
    }

    private fun setRandomNumber() {
        val secondActivity = Intent(this, SecondActivity::class.java)
        secondActivity.putExtra(SecondActivity.LAST_NUMBER, counterValue)
        startActivity(secondActivity)
    }

    private fun incrementCount() {
        findViewById<TextView>(R.id.counter).text = counterValue.inc().toString()
        counterValue = findViewById<TextView>(R.id.counter).text.toString().toInt()
    }

    private fun showToast() {
        counterValue = findViewById<TextView>(R.id.counter).text.toString().toInt()
        Toast.makeText(this, counterValue.toString(), Toast.LENGTH_LONG).show()
    }

}
