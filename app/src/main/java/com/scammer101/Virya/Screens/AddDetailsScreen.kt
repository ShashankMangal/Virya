package com.scammer101.Virya.Screens

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.scammer101.Virya.databinding.ActivityAddDetailsScreenBinding

class AddDetailsScreen : AppCompatActivity() {

    private lateinit var binding : ActivityAddDetailsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setListeners()

    }

    private fun init()
    {
        setStatusBarColor(Color.parseColor("#ffffff"))
    }

    private fun setListeners()
    {
        binding.profileDetailsBackButton.setOnClickListener{onBackPressed()}
    }


    fun Activity.setStatusBarColor(color: Int) {
        var flags = window?.decorView?.systemUiVisibility // get current flag
        if (flags != null) {
            if (isColorDark(color)) {
                flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                window?.decorView?.systemUiVisibility = flags
            } else {
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window?.decorView?.systemUiVisibility = flags
            }
        }
        window?.statusBarColor = color
    }

    fun Activity.isColorDark(color: Int): Boolean {
        val darkness =
            1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return darkness >= 0.5
    }

}