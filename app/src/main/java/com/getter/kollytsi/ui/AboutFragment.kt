package com.getter.kollytsi.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.getter.kollytsi.R
import com.getter.kollytsi.databinding.FragmentAboutBinding
import com.getter.kollytsi.util.autoCleanedVariable

class AboutFragment : Fragment(R.layout.fragment_about) {

    private val binding by autoCleanedVariable { FragmentAboutBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
