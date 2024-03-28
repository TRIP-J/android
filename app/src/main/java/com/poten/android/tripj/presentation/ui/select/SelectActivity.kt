package com.poten.android.tripj.presentation.ui.select

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
        initView()

        /*
        TODO : 뒤로 가기 처리 고려 하기
         */
    }

    private fun initView() {
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentContainerView.id, CountrySelectFragment())
            .commit()
    }
}