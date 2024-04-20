package com.poten.android.tripj.presentation.ui.select

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.ActivitySelectBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController=navHostFragment.navController
        val navGraph=navController.navInflater.inflate(R.navigation.select_graph)

        navController.graph=navGraph


        /*
        TODO : 뒤로 가기 처리 고려 하기
         */
    }
}