package com.example.ozinshe

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.ozinshe.databinding.ActivityAuthBinding

class SignInActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthRepository(RetrofitInstance.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack: ImageButton = findViewById(R.id.btn_back)
        val linkToReg = findViewById<TextView>(R.id.linkToReg)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val signInButton: ImageButton = findViewById(R.id.loginButton)

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        linkToReg.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                authViewModel.signIn(email, password) { response ->
                    if (response != null) {
                        Log.d("SignInActivity", "Success: ${response.username}, Token: ${response.accessToken}")
                        Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, HomePage::class.java))
                    } else {
                        Log.d("SignInActivity", "Error: Sign in failed")
                        Toast.makeText(this, "Sign in failed", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

    }
}