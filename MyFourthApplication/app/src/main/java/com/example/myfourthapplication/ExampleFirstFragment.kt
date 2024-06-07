package com.example.myfourthapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myfourthapplication.data.RetrofitService
import com.example.myfourthapplication.databinding.FragmentExampleFirstBinding
import kotlinx.coroutines.launch
import kotlin.math.log

class ExampleFirstFragment : Fragment() {

    private lateinit var binding: FragmentExampleFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentExampleFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_exampleFirstFragment_to_exampleSecondFragment)
        }

        binding.button2.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val data = RetrofitService.apiService.getMemes()
                    binding.textViewFact.text = data.text
                }
                catch (e: Exception) {
                    Log.d("AAA", e.message.toString())
                }
            }
        }
    }

}