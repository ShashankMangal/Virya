package com.scammer101.Virya.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.scammer101.Virya.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}