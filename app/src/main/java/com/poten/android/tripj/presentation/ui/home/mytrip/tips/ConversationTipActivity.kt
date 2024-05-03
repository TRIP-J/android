package com.poten.android.tripj.presentation.ui.home.mytrip.tips

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.poten.android.tripj.databinding.ActivityConverstationTipBinding

class ConversationTipActivity : AppCompatActivity() {

    private lateinit var binding : ActivityConverstationTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityConverstationTipBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}