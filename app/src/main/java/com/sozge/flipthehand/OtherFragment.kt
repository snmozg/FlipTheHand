package com.sozge.flipthehand

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import com.sozge.flipthehand.databinding.FragmentMenuBinding
import com.sozge.flipthehand.databinding.FragmentOtherBinding


class OtherFragment : Fragment() {
    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    private var animation1: Animation?=null
    private var animation2:Animation?=null
    private var setTime:CountDownTimer?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun playAnimation()
    {
        binding?.ivIconP1?.setBackgroundResource(R.drawable.animation)
        animation1= binding?.ivIconP1?.background as Animation
        binding?.ivIconP2?.setBackgroundResource(R.drawable.animation)
        animation1= binding?.ivIconP2?.background as Animation

        setTime= object :  CountDownTimer(3000,1000)
        {
            override fun onTick(p0: Long) {
                animation1?.start()
                animation2?.start()
            }

            override fun onFinish() {
                animation1?.stop()
            }
        }

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


