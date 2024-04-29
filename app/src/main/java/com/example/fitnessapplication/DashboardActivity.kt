package com.example.fitnessapplication

// Import necessary Android and Kotlin libraries.
import android.content.Intent  // Used to start new activities.
import android.os.Bundle  // Bundle class used to pass data between activities.
import androidx.appcompat.app.AppCompatActivity  // Base class for activities that use the support library for compatibility.
import com.example.fitnessapplication.databinding.ActivityMainBinding  // Generated binding class for activity_main.xml.

/**
 * MainActivity class inherits from AppCompatActivity, which provides compatibility support for older versions of Android.
 * This class is where the application starts after launch.
 */
class MainActivity : AppCompatActivity() {
    // Declares a late-initialized property for view binding. View binding is a feature that allows you to more easily
    // write code that interacts with views by providing compile-time safety when referencing views in your code.
    private lateinit var binding: ActivityMainBinding

    /**
     * onCreate is a lifecycle method that is called when the activity is first created.
     * It is where you initialize your activity. Most importantly, this method is where you do your setup for the
     * activity's user interface.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle
     * contains the data it most recently supplied in onSaveInstanceState(Bundle). Note: Otherwise it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Calls the onCreate method of the parent class (AppCompatActivity) to ensure that all the necessary initializations are performed.
        // This call is crucial because it restores the saved state through the savedInstanceState Bundle, which can hold the state of the activity
        // if it was previously terminated. This ensures that your activity starts up correctly, with all the necessary parts of the Android framework
        // properly initialized. Failing to call super.onCreate(savedInstanceState) can result in exceptions and a non-functional application.
        super.onCreate(savedInstanceState)


        // Inflate the layout XML file and prepare it to show on the screen.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the view for the activity using the root view from the binding object which holds all the views in the layout file.
        setContentView(binding.root)

        // Set up a click listener on the login button to handle user clicks.
        binding.loginButton.setOnClickListener {
            // Retrieve text entered by the user in the username and password fields.
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            // Check if the username and password match predetermined valid credentials.
            if (username == "admin" && password == "admin") { // This is a basic check and usually, you'll check against credentials stored securely elsewhere.
                // If the user inputs valid credentials, navigate to the DashboardActivity.
                val intent = Intent(this, DashboardActivity::class.java)
                // Use the Intent to start the DashboardActivity.
                startActivity(intent)
            }
        }
    }
}
