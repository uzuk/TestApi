package com.example.testapi.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.testapi.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        ///binding
        val binding = MainFragmentBinding.inflate(inflater)

        ///viewModel
        val mainViewModel: MainViewModel by viewModels()
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        ///binding viewModel variable
        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel


        return binding.root
    }


}