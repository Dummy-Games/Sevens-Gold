package com.getter.kollytsi.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.getter.kollytsi.R
import com.getter.kollytsi.databinding.FragmentStartingBinding
import com.getter.kollytsi.util.autoCleanedVariable

class StartingFragment : Fragment(R.layout.fragment_starting) {

    private val binding by autoCleanedVariable { FragmentStartingBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            btnAbout.setOnClickListener {
                findNavController().navigate(R.id.aboutFragment)
            }

            btnPlay.setOnClickListener {
                findNavController().navigate(R.id.gameFragment)
            }
        }
    }
}
