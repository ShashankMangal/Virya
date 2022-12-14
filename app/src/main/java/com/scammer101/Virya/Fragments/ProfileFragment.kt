package com.scammer101.Virya.Fragments

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.scammer101.Virya.Models.UserModel
import com.scammer101.Virya.R
import com.scammer101.Virya.Screens.AddDetailsScreen
import com.scammer101.Virya.Screens.NumberScreen
import com.scammer101.Virya.databinding.FragmentHomeBinding
import com.scammer101.Virya.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var firestore : FirebaseFirestore
    private var userModel: UserModel? = null
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
        binding.profileAddDetail.setOnClickListener {
            var intent = Intent(context, AddDetailsScreen::class.java)
            startActivity(intent)
        }
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("Users").document(FirebaseAuth.getInstance().uid.toString()).get()
            .addOnSuccessListener { doc ->
                try {
                    userModel = doc.toObject(UserModel::class.java)
                    binding.profileUserName.setText(userModel!!.name.toString())
                    if(userModel!!.goalWeight!="") {
                        binding.profileGoalWeight.setText(userModel!!.goalWeight.toString() + " Kg")
                    }
                    if(userModel!!.startWeight!="") {
                        binding.profileStartWeight.setText(userModel!!.startWeight.toString() + " Kg")
                    }
                    if(userModel!!.currentWeight!="") {
                        binding.profileCurrentWeight.setText(userModel!!.currentWeight.toString() + " Kg")
                    }
                    binding.profileTrainingCompleted.setText(userModel!!.trainingCompleted.toString())
                    binding.profileTotalTime.setText(userModel!!.totalTimeCompleted.toString())
                    binding.profileTotalAsanas.setText(userModel!!.totalAsanasCompleted.toString())

                    if (userModel!!.profileImage != "") {
                        val decodedString: ByteArray = Base64.decode(userModel!!.profileImage, Base64.DEFAULT)
                        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

                        Glide.with(this)
                            .load(decodedByte).thumbnail(Glide.with(this).load(R.drawable.spinner))
                            .into(binding.profileUserImage)
                    } else {
                        binding.profileUserImage.setImageResource(R.drawable.demo_user)
                    }

                } catch (e: Exception) {
                    Toast.makeText(context, "Error:"+e.message, Toast.LENGTH_SHORT).show()

                }

            }

        binding.profileLogout.setOnClickListener{
            auth.signOut()
            var intent = Intent(context, NumberScreen::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}