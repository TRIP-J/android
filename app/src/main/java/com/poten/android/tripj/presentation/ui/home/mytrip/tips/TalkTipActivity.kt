package com.poten.android.tripj.presentation.ui.home.mytrip.tips

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.poten.android.tripj.databinding.ActivityTalkTipBinding

class TalkTipActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTalkTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTalkTipBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}