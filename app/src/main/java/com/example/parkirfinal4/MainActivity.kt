package com.example.parkirfinal4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Function to handle button click
    fun goToNextPage(view: View)

    {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}