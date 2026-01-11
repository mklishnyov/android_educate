package com.example.myfirstapplicationonandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapplicationonandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun getNumbers(): Pair<Int, Int> {
            val first = binding.firstNumber.text.toString().toIntOrNull() ?: 0
            val second = binding.secondNumber.text.toString().toIntOrNull() ?: 0
            return Pair(first, second)
        }

        binding.btnSum.setOnClickListener {
            val (firstNumber, secondNumber) = getNumbers()
            binding.resultView.text = (firstNumber + secondNumber).toString()
        }

        binding.btnDiff.setOnClickListener {
            val (firstNumber, secondNumber) = getNumbers()
            binding.resultView.text = (firstNumber - secondNumber).toString()
        }

        binding.btnMulti.setOnClickListener {
            val (firstNumber, secondNumber) = getNumbers()
            binding.resultView.text = (firstNumber * secondNumber).toString()
        }

        binding.btnDevide.setOnClickListener {
            val (firstNumber, secondNumber) = getNumbers()
            if (secondNumber == 0) {
                binding.resultView.text = "Error"
                return@setOnClickListener
            } else {
                binding.resultView.text = (firstNumber.toDouble() / secondNumber).toString()
            }
        }

        binding.btnIntDiv.setOnClickListener {
            val (firstNumber, secondNumber) = getNumbers()
            if (secondNumber == 0) {
                binding.resultView.text = "Error"
                return@setOnClickListener
            } else {
                binding.resultView.text = (firstNumber / secondNumber).toString()
            }
        }

        binding.btnDivWithRem.setOnClickListener {
            val (firstNumber, secondNumber) = getNumbers()
            if (secondNumber == 0) {
                binding.resultView.text = "Error"
                return@setOnClickListener
            } else {
                binding.resultView.text = (firstNumber % secondNumber).toString()
            }
        }


    }
}