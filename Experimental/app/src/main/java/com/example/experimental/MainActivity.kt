package com.example.experimental

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val indicator: CircleIndicator3 = findViewById(R.id.indicator)

        val images = listOf(
            R.drawable.shape,
            R.drawable.shape__1_,
            R.drawable.shape__2_
        )

        val adapter = ImageAdapter(images)
        viewPager.adapter = adapter
        indicator.setViewPager(viewPager)
    }
}