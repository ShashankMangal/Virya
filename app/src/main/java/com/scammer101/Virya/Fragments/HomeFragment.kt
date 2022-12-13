package com.scammer101.Virya.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scammer101.Virya.R
import com.scammer101.Virya.databinding.ActivityMainScreenBinding
import com.scammer101.Virya.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.greetings.text = getGreetingMessage()
        binding.day.text = buildString {
            append("Day ")
            append(getDay())
        }
        return binding.root
    }

    private fun getDay(): String{
        val c = Calendar.getInstance()
        return (c.get(Calendar.DAY_OF_WEEK)).toString()
    }

    fun getGreetingMessage():String{
        val c = Calendar.getInstance()
        return when (c.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good Morning,"
            in 12..15 -> "Good Afternoon,"
            in 16..20 -> "Good Evening,"
            in 21..23 -> "Good Night,"
            else -> "Hello,"
        }
    }
}