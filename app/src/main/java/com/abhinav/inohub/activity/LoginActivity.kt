package com.abhinav.inohub.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abhinav.inohub.R

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences(getString(R.string.Preferences_file_name), MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val login = findViewById<Button>(R.id.login_button)
        val validUserPN = "0123456789"
        val validPassword = arrayOf("Startup","Mentor","Admin","Entrepreneur")

        login.setOnClickListener {
            val userpn = findViewById<EditText>(R.id.user_pn).text.toString()
            val userpass = findViewById<EditText>(R.id.user_pass).text.toString()
            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if (userpn == validUserPN) {
                when (userpass) {
                    validPassword[0], validPassword[1], validPassword[2],validPassword[3] -> {
                        val inohub = when (userpass) {
                            validPassword[0] -> "startup"
                            validPassword[1] -> "mentor"
                            validPassword[2] -> "admin"
                            else -> "entrepreneur"
                        }
                        savedPreferences(inohub)
                        startActivity(intent)
                        finish() // finish the current activity after logging in
                    }
                    else -> {
                        Toast.makeText(this, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            } else if (userpn.isEmpty() || userpass.isEmpty()) {
                Toast.makeText(this, "Please enter credentials", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun savedPreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("title", title).apply()
    }
}
