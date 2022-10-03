package com.example.amphibians.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.amphibians.databinding.FragmentAmphibianDetailBinding


class AmphibianDetailFragment : Fragment() {

    private val viewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = FragmentAmphibianDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        return binding.root
    }
}