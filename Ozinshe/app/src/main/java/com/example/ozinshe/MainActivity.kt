package com.example.ozinshe

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.ozinshe.databinding.ActivityMainBinding
import me.relex.circleindicator.CircleIndicator3

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        val button1: ImageButton = findViewById(R.id.button1)
        val button2: ImageButton = findViewById(R.id.button2)

        val image = listOf(R.drawable.pic_main1, R.drawable.pic_main2, R.drawable.pic_main3)
        val text = listOf(
            getString(R.string.main_body1),
            getString(R.string.main_body2),
            getString(R.string.main_body3)
        )

        val adapter = MainImageAdapter(image, text)
        viewPager.adapter = adapter
        indicator.setViewPager(viewPager)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    button1.visibility = View.GONE
                    button2.visibility = View.VISIBLE
                } else {
                    button1.visibility = View.VISIBLE
                    button2.visibility = View.GONE
                }
                }
        })

        button1.setOnClickListener {
            viewPager.setCurrentItem(image.size - 1, true)
        }

        button2.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }
}
