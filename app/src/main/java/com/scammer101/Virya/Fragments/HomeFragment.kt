package com.scammer101.Virya.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scammer101.Virya.Models.YogaPose
import com.scammer101.Virya.R
import com.scammer101.Virya.adapters.HomeDaysRecyclerAdapter
import com.scammer101.Virya.adapters.HomePosesRecyclerAdapter
import com.scammer101.Virya.databinding.FragmentHomeBinding
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var list : ArrayList<YogaPose>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.greetings.text = getGreetingMessage()
        binding.day.text = buildString {
            append("Day ")
            append(getDay())
        }
        binding.daysRecyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
        binding.daysRecyclerView.adapter = HomeDaysRecyclerAdapter(date)
        binding.posesRecyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
        binding.posesRecyclerView.setHasFixedSize(true)
        list = ArrayList()

        list.add(YogaPose(R.drawable.warrior_2_pose_image_recyclerview, "warrior2pose"))
        list.add(YogaPose(R.drawable.treepose_image_recyclerview, "treepose"))
        list.add(YogaPose(R.drawable.tpose_image_recyclerview, "tpose"))

        binding.posesRecyclerView.adapter = HomePosesRecyclerAdapter(requireActivity(), list)
        binding.monthNyear.text = buildString {
            append(Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()).subSequence(0, 3))
            append(" ")
            append(Calendar.getInstance().get(Calendar.YEAR))
        }

        if(date>4){
            binding.daysRecyclerView.scrollToPosition(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)-4)
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