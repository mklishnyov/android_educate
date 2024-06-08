package com.example.ozinshe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.ozinshe.data.MoviesResponse
import com.example.ozinshe.data.RetrofitInstance
import com.example.ozinshe.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class HomeFragment() : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var textView: TextView

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        textView = view!!.findViewById(R.id.textView4)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchMovies()
    }

    private fun fetchMovies() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.apiService.getMovies()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}