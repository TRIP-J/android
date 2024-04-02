package com.poten.android.tripj.presentation.ui.home.mytrip.tips

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.poten.android.tripj.databinding.ActivityCautionTipBinding

class CautionTipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCautionTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCautionTipBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}