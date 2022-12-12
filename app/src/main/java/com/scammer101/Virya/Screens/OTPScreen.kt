package com.scammer101.Virya.Screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scammer101.Virya.databinding.ActivityOtpscreenBinding

class OTPScreen : AppCompatActivity() {

    private lateinit var binding: ActivityOtpscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}