package com.example.cicdtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.cicdtest.databinding.FragmentCounterBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class CounterFragment : Fragment() {

    private val viewModel: CounterViewModel by activityViewModels()
    private var _binding: FragmentCounterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCount().observe(viewLifecycleOwner, Observer { count ->
            Log.d("debug", "changed: $count")
            binding.textviewCounter.text = count.toString()
        })

        binding.buttonCount.setOnClickListener {
            Log.d("debug", "button Pressed")
            viewModel.onButtonPressed()
        }
    }
}