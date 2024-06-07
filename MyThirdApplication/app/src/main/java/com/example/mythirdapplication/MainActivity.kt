package com.example.mythirdapplication

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mythirdapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val doo = MediaPlayer.create(this, R.raw.doo)
        val re = MediaPlayer.create(this, R.raw.re)
        val mi = MediaPlayer.create(this, R.raw.mi)
        val fa = MediaPlayer.create(this, R.raw.fa)
        val sol = MediaPlayer.create(this, R.raw.sol)
        val lya = MediaPlayer.create(this, R.raw.lja)
        val si = MediaPlayer.create(this, R.raw.si)

        binding.btnDo.setOnClickListener {
            doo.start()
        }

        binding.btnRe.setOnClickListener {
            re.start()
        }

        binding.btnMi.setOnClickListener {
            mi.start()
        }

        binding.btnFa.setOnClickListener {
            fa.start()
        }

        binding.btnSol.setOnClickListener {
            sol.start()
        }

        binding.btnLya.setOnClickListener {
            lya.start()
        }

        binding.btnSi.setOnClickListener {
            si.start()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}