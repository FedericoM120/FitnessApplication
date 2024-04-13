package com.example.fitnessapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapplication.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize your buttons and other UI elements here
        //comments
        //comments
    }
}