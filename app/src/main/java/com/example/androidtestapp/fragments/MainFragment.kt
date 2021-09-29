package com.example.androidtestapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.androidtestapp.R
import com.example.androidtestapp.databinding.FragmentMainBinding
import com.example.androidtestapp.viewmodels.MainFragmentViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException()

    private val viewModel: MainFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        // Inflate the layout for this fragment
        binding.button.setOnClickListener {
            val action = MainFragmentDirections
                .actionMainFragmentToSecondFragment(
                    name = binding.editTextTextPersonName.text.toString()
                )
            findNavController().navigate(action)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.user.collect { user ->
                user?.let {
                    binding.editTextTextPersonName.setText(it.name)
                }
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}