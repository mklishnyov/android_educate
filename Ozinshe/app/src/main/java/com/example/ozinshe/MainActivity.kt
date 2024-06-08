package com.example.ozinshe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.ozinshe.databinding.ActivityMainBinding
import me.relex.circleindicator.CircleIndicator3

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        val button1: ImageButton = findViewById(R.id.button1)
        val button2: ImageButton = findViewById(R.id.button2)

        val images = listOf(
            Pair(R.drawable.pic_main1, R.drawable.ic_main_head),
            Pair(R.drawable.pic_main2, R.drawable.ic_main_head2),
            Pair(R.drawable.pic_main3, R.drawable.ic_main_head3)
        )

        val adapter = MainImageAdapter(images)
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
            viewPager.setCurrentItem(images.size - 1, true)
        }

        button2.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}
