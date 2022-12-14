package com.scammer101.Virya.Fragments

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.scammer101.Virya.Models.CustomGoalModel
import com.scammer101.Virya.Models.DailyYogaModel
import com.scammer101.Virya.Screens.CustomGoalScreen
import com.scammer101.Virya.Screens.PoseDetectorActivity
import com.scammer101.Virya.Utilities.ConstantsValues
import com.scammer101.Virya.Utilities.PreferenceManager
import com.scammer101.Virya.adapters.GoalsAdapter
import com.scammer101.Virya.databinding.FragmentGoalsBinding
import java.util.*

class GoalsFragment : Fragment() {

    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!
    private var currentProgress: Int = 0
    private var preferenceManager: PreferenceManager? = null
    private lateinit var firestore: FirebaseFirestore
    private var dailyModel: DailyYogaModel? = null
    private lateinit var yogaArrayList: ArrayList<CustomGoalModel>
    private lateinit var adapter: GoalsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)

        init()
        val date = preferenceManager!!.getString(ConstantsValues.KEY_DATE_ONLY)

        firestore.collection("CustomGoals")
            .whereEqualTo("dateAndUser", date + FirebaseAuth.getInstance().uid.toString())
            .addSnapshotListener(
                EventListener<QuerySnapshot?> { value, error ->

                    for (dc in value!!.documentChanges) {
                        if (dc.type == DocumentChange.Type.ADDED) {
                            yogaArrayList!!.add(dc.document.toObject(CustomGoalModel::class.java))
                        }
                        adapter.notifyDataSetChanged()
                    }
                })


        binding.setCustomGoal.setOnClickListener {
            var intent = Intent(context, CustomGoalScreen::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    private fun init() {
        currentProgress = 80
        ObjectAnimator.ofInt(binding.goalsProgressBar, "progress", currentProgress)
            .setDuration(2000).start()
        preferenceManager = PreferenceManager(context)
        firestore = FirebaseFirestore.getInstance()
        yogaArrayList = ArrayList()
        adapter = GoalsAdapter(requireContext(), yogaArrayList)
        binding.goalsRecyclerView.adapter = adapter
    }


}