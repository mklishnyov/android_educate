package com.example.ozinshe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.ozinshe.data.MovieViewModel
import com.example.ozinshe.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private lateinit var moviePagerAdapter: MoviePagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            moviePagerAdapter = MoviePagerAdapter(movies)
            binding.rvMovie.adapter = moviePagerAdapter
        })

        movieViewModel.fetchMovies()
    }
}