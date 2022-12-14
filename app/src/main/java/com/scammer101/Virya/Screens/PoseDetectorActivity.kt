package com.scammer101.Virya.Screens

import android.graphics.Bitmap
import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.pose.PoseDetection
import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions
import com.scammer101.Virya.R
import com.scammer101.Virya.databinding.ActivityPoseDetectorBinding

class PoseDetectorActivity : AppCompatActivity() {
    private lateinit var activityPoseDetectorBinding: ActivityPoseDetectorBinding

    private lateinit var bitmapBuffer: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pose_detector)
    }

    fun setProcessor(bitmap: Bitmap){
        val poseDetectorOptions = AccuratePoseDetectorOptions.Builder()
            .setDetectorMode(AccuratePoseDetectorOptions.STREAM_MODE)
            .build()
    }

}