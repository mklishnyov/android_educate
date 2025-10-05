package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerview.databinding.ActivityMainBinding

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

        val listOfProducts = listOf<Product>(
            Product("Parrot", 100),
            Product("Apple", 120),
            Product("Orange", 150),
            Product("Banana", 100),
            Product("Pear", 120),
            Product("Kiwi", 150),
            Product("Lemon", 100),
            Product("Strawberry", 120),
            Product("Blueberry", 150),
            Product("Cherry", 100),
            Product("Peach", 120),
            Product("Mango", 150),
            Product("Pineapple", 100),
            Product("Watermelon", 120),
            Product("Grapes", 150),
            Product("Pomegranate", 100),
            Product("Guava", 120),
        )

        val adapter = ExampleRecyclerAdapter()
        binding.rcProducts.adapter = adapter
        adapter.submit(listOfProducts)

    }
}