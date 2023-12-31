package com.example.parkirfinal4

import DatabaseHelper
import DatabaseHelperCost
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.parkirfinal4.databinding.ActivityRincianPilihanBinding
import java.util.*

class RincianPilihan : AppCompatActivity() {

    private lateinit var startDatePicker: DatePicker
    private lateinit var endDatePicker: DatePicker
    private lateinit var costPerDayTextView: TextView
    private lateinit var totalCostTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rincian_pilihan)

        startDatePicker = findViewById(R.id.startDatePicker)
        endDatePicker = findViewById(R.id.endDatePicker)
        costPerDayTextView = findViewById(R.id.costPerDayTextView)
        totalCostTextView = findViewById(R.id.totalCostTextView)
        calculateButton = findViewById(R.id.calculateButton)
    }

    fun calculateTotalCost(view: android.view.View) {
        val startYear = startDatePicker.year
        val startMonth = startDatePicker.month
        val startDay = startDatePicker.dayOfMonth

        val endYear = endDatePicker.year
        val endMonth = endDatePicker.month
        val endDay = endDatePicker.dayOfMonth

        val calendarStart = Calendar.getInstance()
        calendarStart.set(startYear, startMonth, startDay)

        val calendarEnd = Calendar.getInstance()
        calendarEnd.set(endYear, endMonth, endDay)

        val millisecondsPerDay = 24 * 60 * 60 * 1000 // Number of milliseconds in a day
        val costPerDay = 10 // Replace with your actual parking lot cost per day

        val daysDifference = ((calendarEnd.timeInMillis - calendarStart.timeInMillis) / millisecondsPerDay) + 1

        val totalCost = (daysDifference * costPerDay).toInt()
        totalCostTextView.text = "Total Cost: $$totalCost"

// Inside your RincianPilihan activity
        val dbHelper = DatabaseHelperCost(this)
        dbHelper.addCost(totalCost) // Assuming you have a function like addCost to insert the cost into the database


    }
}
