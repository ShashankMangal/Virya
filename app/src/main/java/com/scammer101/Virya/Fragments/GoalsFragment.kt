package com.scammer101.Virya.Fragments

import android.animation.ObjectAnimator
import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scammer101.Virya.R
import com.scammer101.Virya.databinding.FragmentGoalsBinding

class GoalsFragment : Fragment() {

    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!
    private var currentProgress : Int = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)

        init()

        return binding.root
    }

    private fun init()
    {
        currentProgress = 80
        ObjectAnimator.ofInt(binding.goalsProgressBar, "progress", currentProgress).setDuration(2000).start()
    }

}