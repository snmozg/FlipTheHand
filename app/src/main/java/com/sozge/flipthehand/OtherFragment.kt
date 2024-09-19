package com.sozge.flipthehand

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sozge.flipthehand.databinding.FragmentOtherBinding


class OtherFragment : Fragment() {
    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    private var animation1 : AnimationDrawable? = null
    private var animation2 : AnimationDrawable? = null
    private var setTime : CountDownTimer? = null


    private var player1Ready = false
    private var player2Ready= false
    private var allowPlaying = true

    private lateinit var selectionP1: String
    private lateinit var selectionP2: String

    private var scoreP1 = 0
    private var scoreP2 = 0

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

        binding.otherRockButton.setOnClickListener {
            onPlayP1("rock")

        }
        binding.otherPaperButton.setOnClickListener{
            onPlayP1("paper")
        }
        binding.otherScissorButton.setOnClickListener{
            onPlayP1("scissor")
        }
        binding.rockButton.setOnClickListener{
            onPlayP2("rock")
        }
        binding.paperButton.setOnClickListener{
            onPlayP2("paper")
        }
        binding.scissorButton.setOnClickListener{
            onPlayP2("scissor")
        }
    }

    private fun playAnimation()
    {

        binding.ivIconP1.setImageResource(0)
        binding.ivIconP2.setImageResource(0)
        binding.P1Status.text=""
        binding.P2Status.text=""
        binding.ivIconP1.setBackgroundResource(R.drawable.animation)
        animation1= binding.ivIconP1.background as AnimationDrawable

        binding.ivIconP2.setBackgroundResource(R.drawable.animation)
        animation2= binding.ivIconP2.background as AnimationDrawable

        setTime= object :  CountDownTimer(3000,1000)
        {
            override fun onTick(p0: Long) {
                animation1?.start()
                animation2?.start()
            }
            override fun onFinish() {
                animation1?.stop()
                animation2?.stop()
                allowPlaying = true
                player1Ready = false
                player2Ready = false

                binding.ivIconP1.setBackgroundResource(0)
                binding.ivIconP2.setBackgroundResource(0)

                setSelectedIcon()
                setScore()
            }
        }.start()
    }

    private fun onPlayP1(selection:String) {
        if (allowPlaying)
        {
            binding.ivIconP1?.setImageResource(R.drawable.check)
            binding.P1Status?.text = "Ready"
            selectionP1 = selection
            player1Ready= true

            if (player2Ready){
                playAnimation()

            }
        }
    }

    private fun onPlayP2(selection:String) {
        if (allowPlaying)
        {
            binding.ivIconP2.setImageResource(R.drawable.check)
            binding.P2Status.text = "Ready"
            selectionP2 = selection
            player2Ready= true

            if (player1Ready){
                playAnimation()

            }
        }
    }

    private fun setSelectedIcon(){
        when(selectionP1)
        {
            "rock" -> binding.ivIconP1.setImageResource(R.drawable.rock)
            "paper" -> binding.ivIconP1.setImageResource(R.drawable.paper)
            "scissor" -> binding.ivIconP1.setImageResource(R.drawable.scissor)
        }

        when(selectionP2){
            "rock" -> binding.ivIconP2.setImageResource(R.drawable.rock)
            "paper" -> binding.ivIconP2.setImageResource(R.drawable.paper)
            "scissor" -> binding.ivIconP2.setImageResource(R.drawable.scissor)
        }
    }
    private fun getResult():String{
        return if (selectionP1 == selectionP2)
            "tie"
        else if(selectionP1=="rock" && selectionP2 == "scissor" ||
                selectionP1=="paper" && selectionP2 == "rock" ||
                selectionP1== "scissor" && selectionP2 == "paper")
            "P1"
            else
            "P2"
    }

    private fun setScore() {
        if (getResult()=="tie"){
            binding.P1Status.text="Tie"
            binding.P2Status.text="Tie"
        }
        else if(getResult()=="P1"){
            binding.P1Status.text="Win"
            binding.P2Status.text="Lose"
        scoreP1++
            when(scoreP1){
                1-> binding.P2s1.setImageResource(R.drawable.star1)
                2->binding.P2s2.setImageResource(R.drawable.star1)
                3->binding.P2s3.setImageResource(R.drawable.star1)
            }
        }
        else{
            binding.P1Status.text="Lose"
            binding.P2Status.text="Win"
            scoreP2++
            when(scoreP2){
                1-> binding.P1s1.setImageResource(R.drawable.star1)
                2-> binding.P1s2.setImageResource(R.drawable.star1)
                3-> binding.P1s3.setImageResource(R.drawable.star1)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


