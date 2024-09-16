package com.sozge.flipthehand

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sozge.flipthehand.databinding.FragmentMenuBinding
import com.sozge.flipthehand.databinding.FragmentOtherBinding


class OtherFragment : Fragment() {
    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOtherBinding.inflate(inflater,container, false)
        val view = binding.root
        return view }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}


