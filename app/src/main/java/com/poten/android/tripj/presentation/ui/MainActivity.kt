package com.poten.android.tripj.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.ActivityMainBinding
import com.poten.android.tripj.presentation.uistate.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        initNav()

    }

    private fun initNav() {
        val bottomNavConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment,
                R.id.countrySelectFragment,
                R.id.userInputFragment,
                R.id.historyListFragment,
                R.id.historyDetailFragment,
                R.id.postDetailFragment,
                R.id.postEditFragment,
                R.id.conversationTipFragment,
                R.id.cautionTipFragment,
                R.id.cautionDetailFragment,
            )
        )

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigationView.isVisible =
                !bottomNavConfiguration.topLevelDestinations.contains(
                    destination.id
                )
        }
    }
}

