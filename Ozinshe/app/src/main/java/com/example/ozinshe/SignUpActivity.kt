package com.example.ozinshe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ozinshe.data.AuthRepository
import com.example.ozinshe.data.AuthViewModel
import com.example.ozinshe.data.AuthViewModelFactory
import com.example.ozinshe.data.RetrofitInstance
import com.example.ozinshe.databinding.ActivityRegBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegBinding
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthRepository(RetrofitInstance.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack: ImageButton = findViewById(R.id.btn_back)
        val linkToAuth = findViewById<TextView>(R.id.linkToAuth)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val confirmPasswordEditText: EditText = findViewById(R.id.confirmPasswordEditText)
        val signUpButton: ImageButton = findViewById(R.id.signUpButton)

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        linkToAuth.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    authViewModel.signUp(email, password) { response ->
                        if (response != null) {
                            Log.d("SignUpActivity", "Success: ${response.username}, Token: ${response.accessToken}")
                            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        } else {
                            Log.d("SignUpActivity", "Error: Registration failed")
                            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}