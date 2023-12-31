package com.example.parkirfinal4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val username = intent.getStringExtra("USERNAME")
        val textViewUsername = findViewById<TextView>(R.id.textViewUsername)
        textViewUsername.text = username
    }
    // Function to handle button click
    fun goToNextPage(view: View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    fun goToMap(view: View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    fun goToStruk(view: View) {
        val intent = Intent(this, ListStruk::class.java)
        startActivity(intent)
    }
}