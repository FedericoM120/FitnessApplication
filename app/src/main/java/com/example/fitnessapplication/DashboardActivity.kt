package com.example.fitnessapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapplication.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTrackCalories.setOnClickListener {
            val intent = Intent(this, CalorieTrackerActivity::class.java)
            startActivity(intent)
        }

        // Initialize your buttons and other UI elements here
        //comments
        //comments
    }

}