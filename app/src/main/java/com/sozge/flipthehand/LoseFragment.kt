package com.sozge.flipthehand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sozge.flipthehand.databinding.FragmentLoseBinding
import com.sozge.flipthehand.databinding.FragmentMenuBinding

class LoseFragment : Fragment() {
    private var _binding: FragmentLoseBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {_binding = FragmentLoseBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
        binding.homeButton.setOnClickListener{buttonHomeClicked(it)}
    }

    private fun buttonHomeClicked(view: View) {
        val action = FinishFragmentDirections.actionFinishFragmentToMenuFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }
}