package com.scammer101.Virya.Screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scammer101.Virya.databinding.ActivityDemoVideoScreenBinding

class DemoVideoScreen : AppCompatActivity() {

    private lateinit var binding : ActivityDemoVideoScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoVideoScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    private fun init()
    {

    }

}