package com.example.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragment.databinding.ActivityMainBinding

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

        val fragment1 = ExampleFirstFragment()
        binding.btnShowFragmentFirst.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(binding.tvPlaceForFragment.id, fragment1)
                .commit()
        }
        val fragment2 = ExampleSecondFragment()
        binding.btnShowFragmentSecond.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(binding.tvPlaceForFragment.id, fragment2)
                .commit()
        }

        binding.btnRemoveFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(fragment1)
                .commit()
            supportFragmentManager.beginTransaction()
                .remove(fragment2)
                .commit()
        }

    }
}