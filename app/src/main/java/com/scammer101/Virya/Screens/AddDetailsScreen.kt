package com.scammer101.Virya.Screens

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.scammer101.Virya.Models.DailyYogaModel
import com.scammer101.Virya.Models.UserModel
import com.scammer101.Virya.databinding.ActivityAddDetailsScreenBinding

class AddDetailsScreen : AppCompatActivity() {

    private lateinit var binding : ActivityAddDetailsScreenBinding
    private lateinit var firestore : FirebaseFirestore
    private var userModel: UserModel? = null

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
        firestore = FirebaseFirestore.getInstance()
        getUserData()
    }

    private fun setListeners()
    {
        binding.profileDetailsBackButton.setOnClickListener{onBackPressed()}
    }

    private fun getUserData() {
        firestore.collection("Users").document(FirebaseAuth.getInstance().uid.toString()).get()
            .addOnSuccessListener { doc ->
                try {
                    userModel = doc.toObject(UserModel::class.java)
                    binding.detailsUserName.hint = userModel!!.name.toString()
                    binding.detailsDob.hint = userModel!!.dob.toString()
                    binding.detailsGoalWeight.hint = userModel!!.goalWeight.toString()
                    binding.detailsStartWeight.hint = userModel!!.startWeight.toString()
                    binding.detailsHeight.hint = userModel!!.height.toString()
                    binding.detailsGender.hint = userModel!!.gender.toString()
                } catch (e: Exception) {
                   Toast.makeText(applicationContext, "Error:"+e.message,Toast.LENGTH_SHORT).show()

                }

            }


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