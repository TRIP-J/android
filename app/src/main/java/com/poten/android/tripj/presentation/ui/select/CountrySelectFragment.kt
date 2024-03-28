package com.poten.android.tripj.presentation.ui.select

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentCountrySelectBinding
import com.poten.android.tripj.presentation.uistate.select.SelectViewModel
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import kotlinx.coroutines.launch

class CountrySelectFragment
    : BaseFragment<FragmentCountrySelectBinding>(FragmentCountrySelectBinding::inflate) {

    private val viewModel: SelectViewModel by viewModels()
    private var buttonMap = mapOf<Int, Button>()
    private var focusedButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButtons()
        changeCheckedButton()
        with(binding) {
            nextButton.setOnAvoidDuplicateClick {
                val navController = findNavController()
                navController.apply {
                    navigate(R.id.action_countrySelectFragment_to_userInputFragment)
                }
            }
        }
    }

    private fun setCountry() {
        viewModel.updateCountry(focusedButton?.text.toString())
    }

    private fun setContinent() {
        viewLifecycleOwner.lifecycleScope.launch {
            var continentText=""
            when(focusedButton?.text) {
                "일본","중국","태국","홍콩" -> {
                   continentText=binding.asiaTextView.text.toString()
                }
                "영국","프랑스","이탈리아" -> {
                    continentText=binding.europeTextView.text.toString()
                }
                "미국","캐나다","아르헨티나" -> {
                    continentText=binding.americaTextView.text.toString()
                }
            }
            viewModel.updateContinent(continentText)
        }
    }


    private fun addButtons() {
        buttonMap = mapOf(
            binding.japanButton.id to binding.japanButton,
            binding.chineseButton.id to binding.chineseButton,
            binding.thailandButton.id to binding.thailandButton,
            binding.hongkongButton.id to binding.hongkongButton,
            binding.englandButton.id to binding.englandButton,
            binding.franceButton.id to binding.franceButton,
            binding.italyButton.id to binding.italyButton,
            binding.usaButton.id to binding.usaButton,
            binding.canadaButton.id to binding.canadaButton,
            binding.argentinaButton.id to binding.argentinaButton,
        )
    }

    private fun changeCheckedButton() {
        for (button in buttonMap.values) {
            button.setOnAvoidDuplicateClick {
                button.requestFocus()
                focusedButton?.apply {
                    setBackgroundResource(R.drawable.background_country_button_selected)
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.gray_scale_900))

                }

                button.apply {
                    setBackgroundResource(R.drawable.background_country_button_not_selected)
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.gray_scale_100))
                }
                focusedButton = button

                setContinent()
                setCountry()

                binding.nextButton.apply {
                    setBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.sky_blue_500
                        )
                    )
                    isEnabled = true
                }
            }
        }
    }


    companion object {
        fun newInstance() = CountrySelectFragment()
    }

}