package com.example.fitnessapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapplication.databinding.ActivityCalorieTrackerBinding
import com.example.fitnessapplication.databinding.AddFoodBinding
import com.example.fitnessapplication.databinding.AddGoalBinding

class CalorieTrackerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalorieTrackerBinding
    private var goalCalories = 0
    private var foodCalories = 0
    private var exerciseCalories = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalorieTrackerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener {
            displayAddGoalDialog()
        }

        binding.buttonAddItemBreakfast.setOnClickListener {
            displayAddFoodDialog()
        }

        binding.buttonAddItemLunch.setOnClickListener {
            displayAddFoodDialog()
        }

        binding.buttonAddItemDinner.setOnClickListener {
            displayAddFoodDialog()
        }

        binding.buttonAddItemSnack.setOnClickListener {
            displayAddFoodDialog()
        }

        binding.buttonAddItemExercise.setOnClickListener {
            displayAddFoodDialog()
        }
    }

    private fun displayAddGoalDialog() {
        val dialogBinding = AddGoalBinding.inflate(LayoutInflater.from(this))
        val dialogView = dialogBinding.root

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Add Goal")
            .setPositiveButton("Add") { _, _ ->
                val goal = dialogBinding.editTextGoal.text.toString().toIntOrNull()
                if (goal != null) {
                    goalCalories = goal
                    updateRemainingCalories()
                } else {
                    Toast.makeText(this, "Please enter a valid goal", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun displayAddFoodDialog() {
        val dialogBinding = AddFoodBinding.inflate(LayoutInflater.from(this))
        val dialogView = dialogBinding.root

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Add Food")
            .setPositiveButton("Add") { _, _ ->
                val foodName = dialogBinding.editTextFoodName.text.toString().trim()
                val calories = dialogBinding.editTextCalories.text.toString().toIntOrNull()

                if (foodName.isEmpty() || calories == null) {
                    Toast.makeText(this, "Please enter valid inputs", Toast.LENGTH_SHORT).show()
                } else {
                    foodCalories += calories
                    updateRemainingCalories()
                    // This will store food data to find total amount.
                    Toast.makeText(
                        this,
                        "Food added: $foodName, Calories: $calories",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun updateRemainingCalories() {
        val remainingCalories = goalCalories - foodCalories + exerciseCalories
        binding.textTotal.text = remainingCalories.toString()
        binding.textGoal.text = goalCalories.toString()
        binding.textFood.text = foodCalories.toString()
        binding.textExercise.text = exerciseCalories.toString()
    }
}
