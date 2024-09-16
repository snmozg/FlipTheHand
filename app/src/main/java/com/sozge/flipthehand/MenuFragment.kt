package com.sozge.flipthehand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sozge.flipthehand.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {_binding = FragmentMenuBinding.inflate(inflater,container, false)
        val view = binding.root
        return view }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPc.setOnClickListener{ buttonPcClicked(it) }
        binding.buttonOther.setOnClickListener{ buttonOtherClicked(it) }
    }

    private fun buttonOtherClicked(view: View) {

    }

    private fun buttonPcClicked(view: View) {

    }
}