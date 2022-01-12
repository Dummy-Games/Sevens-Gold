package com.getter.kollytsi.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.getter.kollytsi.R
import com.getter.kollytsi.databinding.FragmentGameBinding
import com.getter.kollytsi.util.autoCleanedVariable
import com.getter.kollytsi.util.showToast
import com.getter.kollytsi.util.toEditable
import kotlin.random.Random

class GameFragment : Fragment(R.layout.fragment_game) {

    private val binding by autoCleanedVariable { FragmentGameBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            osFirst.getAccess()
            osSecond.getAccess()
            osThird.getAccess()

            btnRoll.setOnClickListener {
                if (Values.score >= 50) {
                    Values.score -= 50
                    binding.tvScore.text = "Score: ${Values.score}"
                    osFirst.animIteration(Random.nextInt(5), (Random.nextInt(6) + 10), 1)
                    osSecond.animIteration(Random.nextInt(5), (Random.nextInt(6) + 10), 2)
                    osThird.animIteration(Random.nextInt(5), (Random.nextInt(6) + 10), 3)
                }
            }

            Values.endOfGame.observe(
                viewLifecycleOwner, {
                    if (Values.endOfGame.value == true) {
                        Values.endOfGame.postValue(false)
                        if (Values.listOfResultImages[0] == Values.listOfResultImages[1] && Values.listOfResultImages[1] == Values.listOfResultImages[2]) {
                            Values.score += 200
                            binding.tvScore.text = "Score: ${Values.score}"
                            Toast.makeText(requireContext(), "Very Lucky!!!", Toast.LENGTH_SHORT).show()
                        } else if (Values.listOfResultImages[0] == Values.listOfResultImages[1] ||
                            Values.listOfResultImages[1] == Values.listOfResultImages[2] ||
                            Values.listOfResultImages[0] == Values.listOfResultImages[2]
                        ) {
                            Values.score += 100
                            binding.tvScore.text = "Score: ${Values.score}"
                            Toast.makeText(requireContext(), "Damn! Not Bad", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(requireContext(), "Looser", Toast.LENGTH_SHORT).show()
                        }
                        Log.d("Array", Values.listOfResultImages.toString())
                        Values.listOfResultImages = mutableListOf(100, 100, 100)
                    }
                }
            )
        }
    }
}
