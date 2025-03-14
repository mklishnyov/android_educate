package com.example.secondprogram

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.secondprogram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var editText1 = ""
        var editText2 = ""

        binding.btnSum.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() + editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }

        binding.btnRzn.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() - editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }

        binding.btnMlt.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() * editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }

        binding.btnDvd.setOnClickListener {
            editText1 = binding.editTextNumber.text.toString()
            editText2 = binding.editTextNumber2.text.toString()

            if (editText1 == "" || editText2 == "") {
                binding.tvResult.text = "Введите числа"

            } else {
                val result = editText1.toInt() / editText2.toInt()
                binding.tvResult.text = result.toString()
            }
        }
    }
}