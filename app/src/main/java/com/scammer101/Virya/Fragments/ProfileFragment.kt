package com.scammer101.Virya.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scammer101.Virya.R
import com.scammer101.Virya.Screens.AddDetailsScreen
import com.scammer101.Virya.databinding.FragmentHomeBinding
import com.scammer101.Virya.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.profileAddDetail.setOnClickListener {
            var intent = Intent(context, AddDetailsScreen::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}