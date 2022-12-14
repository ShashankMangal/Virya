package com.scammer101.Virya.Screens

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.scammer101.Virya.Models.DailyYogaModel
import com.scammer101.Virya.Models.UserModel
import com.scammer101.Virya.R
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
        binding.detailsSaveButton.setOnClickListener { saveUserData() }
    }

    private fun getUserData() {
        firestore.collection("Users").document(FirebaseAuth.getInstance().uid.toString()).get()
            .addOnSuccessListener { doc ->
                try {
                    userModel = doc.toObject(UserModel::class.java)
                    binding.detailsUserName.setText(userModel!!.name.toString())
                    binding.detailsDob.setText(userModel!!.dob.toString())
                    binding.detailsGoalWeight.setText(userModel!!.goalWeight.toString())
                    binding.detailsStartWeight.setText(userModel!!.startWeight.toString())
                    binding.detailsHeight.setText(userModel!!.height.toString())
                    binding.detailsGender.setText(userModel!!.gender.toString())

                    if(!userModel!!.profileImage.equals(""))
                    {
                        Glide.with(applicationContext).load(userModel!!.profileImage).thumbnail(
                            Glide.with(applicationContext).load(R.drawable.spinner)).into(binding.detailProfileImage)
                    }

                } catch (e: Exception) {
                   Toast.makeText(applicationContext, "Error:"+e.message,Toast.LENGTH_SHORT).show()

                }

            }


    }

    private fun saveUserData()
    {
        val name = binding.detailsUserName.text.toString()
        val dob = binding.detailsDob.text.toString()
        val startW = binding.detailsStartWeight.text.toString()
        val height = binding.detailsHeight.text.toString()
        val gender = binding.detailsGender.text.toString()
        val goalW = binding.detailsGoalWeight.text.toString()

        firestore.collection("Users")
            .document(FirebaseAuth.getInstance().uid!!)
            .update(mapOf(
                "name" to name,
                "dob" to dob,
                "goalWeight" to goalW,
                "startWeight" to startW,
                "height" to height,
                "gender" to gender,
            ))
        onBackPressed()
        Toast.makeText(applicationContext, "User Profile Updated.", Toast.LENGTH_SHORT).show()
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