package com.example.android.playapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.util.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    private fun showRandomNumber() {
        val totalCount = intent.getIntExtra(LAST_NUMBER, 0)
        if (totalCount > 0) {
            val random = Random()
            findViewById<TextView>(R.id.heading).text = getString(R.string.any_number_between_0_to_any_number, totalCount)
            findViewById<TextView>(R.id.random_number).text = Integer.toString(random.nextInt(totalCount))
        } else {
            Toast.makeText(this, "Please increment the value of counter", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    companion object {
        const val LAST_NUMBER = "last_number"
    }
}
