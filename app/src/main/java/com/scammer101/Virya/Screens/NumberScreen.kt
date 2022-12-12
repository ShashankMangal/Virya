package com.scammer101.Virya.Screens

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.scammer101.Virya.databinding.ActivityNumberScreenBinding

class NumberScreen : AppCompatActivity() {

    private lateinit var binding : ActivityNumberScreenBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        if(auth.currentUser!=null)
        {
            startActivity(Intent(this, MainScreen::class.java))
            finish()
        }

        binding.numberContinueButton.setOnClickListener{

            if(binding.numberPhoneNumber.text!!.isEmpty() || binding.numberPhoneNumber.text!!.length<10)
            {
                binding.numberTextLayout.setError("Enter Valid Number")
            }
            else
            {
                var intent = Intent(this, OTPScreen::class.java)
                intent.putExtra("number", binding.numberPhoneNumber.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }

    fun init()
    {
        auth = FirebaseAuth.getInstance()
    }

}