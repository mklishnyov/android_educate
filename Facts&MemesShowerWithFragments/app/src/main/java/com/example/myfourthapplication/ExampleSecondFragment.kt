package com.example.myfourthapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myfourthapplication.data.MemesResponse
import com.example.myfourthapplication.data.RetrofitService
import com.example.myfourthapplication.databinding.FragmentExampleSecondBinding
import kotlinx.coroutines.launch

class ExampleSecondFragment : Fragment() {

    private lateinit var binding: FragmentExampleSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentExampleSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_exampleSecondFragment_to_exampleFirstFragment)
        }

        lifecycleScope.launch {
            try {
                val response = RetrofitService.apiServiceMemes.getMemes2()
                val listMemes: List<MemesResponse.Data.Meme> = response.data.memes
                val adapter = ExampleRecyclerAdapter()
                binding.rcViewMemes.adapter = adapter
                adapter.submitList(listMemes)
            } catch (e: Exception) {

            }
        }
    }

}