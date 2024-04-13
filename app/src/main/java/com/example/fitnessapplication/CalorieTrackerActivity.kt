package com.example.fitnessapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapplication.databinding.ActivityCalorieTrackerBinding

class CalorieTrackerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalorieTrackerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalorieTrackerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmitFood.setOnClickListener {
            val foodName = binding.editTextFoodName.text.toString().trim()
            val calories = binding.editTextCalories.text.toString().toIntOrNull()

            if (foodName.isEmpty() || calories == null) {
                Toast.makeText(this, "Please enter valid inputs", Toast.LENGTH_SHORT).show()
            } else {
                // Here, handle the logic to store the food data
                Toast.makeText(this, "Food added: $foodName, Calories: $calories", Toast.LENGTH_LONG).show()
            }
        }
    }
}
