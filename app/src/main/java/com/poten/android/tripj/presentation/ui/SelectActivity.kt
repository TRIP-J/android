package com.poten.android.tripj.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.poten.android.tripj.databinding.ActivitySelectBinding


class SelectActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySelectBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }
}