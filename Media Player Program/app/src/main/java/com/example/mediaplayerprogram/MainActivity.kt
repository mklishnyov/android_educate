package com.example.mediaplayerprogram

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mediaplayerprogram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private var currentIndex = 0

    // список треков
    private val tracks = listOf(
        Track(R.raw.tyomnyi_prince, "Тёмный принц – ПАПА", R.drawable.poster_prince),
        Track(R.raw.icegergert, "ICEGERGERT, SKY RAE - Наслдедство", R.drawable.poster_ice),
        Track(R.raw.tycn_dycn, "Борик - Тыцн-Дыцн", R.drawable.poster_dycn)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songName.visibility = View.GONE
        binding.posterImage.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
        binding.btnPrev.visibility = View.GONE
        binding.btnPause.visibility = View.GONE

        binding.btnPlay.setOnClickListener {
            if (!::mediaPlayer.isInitialized) {
                initPlayer()
            }
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }

            binding.songName.visibility = View.VISIBLE
            binding.posterImage.visibility = View.VISIBLE
            binding.btnNext.visibility = View.VISIBLE
            binding.btnPrev.visibility = View.VISIBLE
            binding.btnPause.visibility = View.VISIBLE
        }

        binding.btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        binding.btnNext.setOnClickListener {
            changeSong(1)
        }

        binding.btnPrev.setOnClickListener {
            changeSong(-1)
        }
    }

    private fun initPlayer() {
        val track = tracks[currentIndex]

        mediaPlayer = MediaPlayer.create(this, track.resId)
        binding.songName.text = track.title
        binding.posterImage.setImageResource(track.poster)
    }

    private fun changeSong(direction: Int) {
        mediaPlayer.stop()
        mediaPlayer.release()

        currentIndex = (currentIndex + direction + tracks.size) % tracks.size
        initPlayer()
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}