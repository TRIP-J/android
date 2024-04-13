package com.poten.android.tripj.presentation.ui.home.mytrip.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.poten.android.tripj.databinding.ActivityHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity: AppCompatActivity() {
    private lateinit var binding : ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHistoryBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }

}