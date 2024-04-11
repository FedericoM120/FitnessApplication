package com.example.fitnessapplication

import android.util.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            // You can now use username and password to authenticate the user
            // For now, we'll just print them to log
            if (username == "admin" && password == "admin") { // Example validation
                // Proceed to next screen or show success
                Log.d("LoginActivity", "Login successful")
            } else {
                // Show error or retry
                Log.d("LoginActivity", "Login failed")
            }
        }
    }
}