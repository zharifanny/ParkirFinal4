package com.example.parkirfinal4;


import DatabaseHelperCost
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.parkirfinal4.R

class ListStruk : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelperCost

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_struk)

        dbHelper = DatabaseHelperCost(this)

        displayCosts()
    }

    private fun displayCosts() {
        val costsList = dbHelper.getAllCosts()

        val costsTextView = findViewById<TextView>(R.id.costsTextView)

        if (costsList.isEmpty()) {
            costsTextView.text = "No costs available."
        } else {
            val stringBuilder = StringBuilder()
            for (cost in costsList) {
                stringBuilder.append("Cost: $cost\n")
            }
            costsTextView.text = stringBuilder.toString()
        }
    }
}
