package com.example.parkirfinal4

import DatabaseHelper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val dbHelper = DatabaseHelper(this)

        val editTextLoginUsername = findViewById<EditText>(R.id.editTextLoginUsername)
        val editTextLoginPassword = findViewById<EditText>(R.id.editTextLoginPassword)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val username = editTextLoginUsername.text.toString().trim()
            val password = editTextLoginPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val isValid = dbHelper.checkUser(username, password)
                if (isValid) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    startActivity(intent)
                    finish()
                // Redirect to another activity after successful login
                    // Example: startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun goToNextPage(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

}
