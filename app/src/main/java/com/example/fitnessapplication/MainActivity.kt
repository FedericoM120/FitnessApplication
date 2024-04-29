// Declare the package for the class. Packages are used to organize related classes and interfaces in Java and Kotlin.
package com.example.fitnessapplication

// Import necessary Android and Kotlin classes and libraries.
import android.content.Intent  // Used to launch other activities within the Android app.
import android.os.Bundle  // Bundle is used for passing data between activities.
import androidx.appcompat.app.AppCompatActivity  // AppCompatActivity provides compatibility support for older versions of Android.
import com.example.fitnessapplication.databinding.ActivityMainBinding  // Generated binding class for activity_main.xml which allows direct interaction with views.

/**
 * MainActivity is the entry point for the application. It extends AppCompatActivity, which means it inherits
 * methods and properties from AppCompatActivity useful for all Android activities.
 */
class MainActivity : AppCompatActivity() {
    // Declare a late-initialized variable for view binding. This allows direct access to the views defined in the corresponding XML file
    // without calling findViewById, reducing boilerplate code and increasing safety.
    private lateinit var binding: ActivityMainBinding

    /**
     * onCreate is one of the lifecycle callback methods in Android apps. It is called when the activity is starting.
     * This method is where you perform initial setup for the activity.
     *
     * @param savedInstanceState If the activity is re-initialized after previously being shut down then this Bundle
     * contains the data it most recently supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Call the onCreate method of the super class (AppCompatActivity) to ensure proper initialization of the activity.
        super.onCreate(savedInstanceState)

        // Inflate the layout XML file linked with this activity and assign it to the current activity's view.
        // This process converts the XML layout file into view objects.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the content view of the activity to the root view of the layout from the binding object.
        setContentView(binding.root)

        // Setup a click listener on the login button. This listener will be triggered when the login button is clicked.
        binding.loginButton.setOnClickListener {
            // Retrieve the text entered by the user in the username and password input fields.
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            // Perform a simple check to see if the entered username and password match predefined credentials.
            // This is a basic authentication check.
            if (username == "admin" && password == "admin") {
                // If the credentials match, create an Intent to start the DashboardActivity.
                // Intents in Android are used for starting new components like activities, services, etc.
                val intent = Intent(this, DashboardActivity::class.java)
                // Use the Intent to start the DashboardActivity, moving the user to the next screen.
                startActivity(intent)
            }
        }
    }
}

