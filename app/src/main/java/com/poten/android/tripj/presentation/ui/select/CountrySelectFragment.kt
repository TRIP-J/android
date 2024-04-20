package com.poten.android.tripj.presentation.ui.select

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentCountrySelectBinding
import com.poten.android.tripj.presentation.uistate.select.SelectViewModel
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CountrySelectFragment
    : BaseFragment<FragmentCountrySelectBinding>(FragmentCountrySelectBinding::inflate) {

    private val viewModel: SelectViewModel by activityViewModels()

    private var buttonList = listOf<Button>()

    private var focusedButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // toolbar 뒤로가기 제거
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        addButtons()
        initCountryButton()
        initNextButton()
    }

    /**
     * Add buttons
     * 10 개의 버튼을 한 번에 관리하기 위함
     * @author harry
     */
    private fun addButtons() {
        buttonList = listOf(
            binding.japanButton,
            binding.chineseButton,
            binding.thailandButton,
            binding.hongkongButton,
            binding.englandButton,
            binding.franceButton,
            binding.italyButton,
            binding.usaButton,
            binding.canadaButton,
            binding.argentinaButton
        )
    }

    private fun initCountryButton() {
        for (button in buttonList) {
            button.setOnAvoidDuplicateClick {
                handleButtonClick(button)
                setCountry()
                setContinent()
                setNextButton()
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun handleButtonClick(clickedButton: Button) {
        if (focusedButton != null) {
            val previousButton = focusedButton
            previousButton?.apply {
                setTextColor(ContextCompat.getColor(requireContext(), R.color.gray_scale_900))
                setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray_scale_100))
            }
        }

        if (focusedButton == clickedButton) {
            focusedButton = null
        } else {
            clickedButton.apply {
                setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.sky_blue_500))

                focusedButton = clickedButton
            }
        }
    }

    private fun setCountry() {
        viewModel.updateCountry(focusedButton?.text.toString())
    }

    private fun setContinent() {
        viewLifecycleOwner.lifecycleScope.launch {
            var continentText = ""
            when (focusedButton?.text) {
                "일본", "중국", "태국", "홍콩" -> {
                    continentText = binding.asiaTextView.text.toString()
                }

                "영국", "프랑스", "이탈리아" -> {
                    continentText = binding.europeTextView.text.toString()
                }

                "미국", "캐나다", "아르헨티나" -> {
                    continentText = binding.americaTextView.text.toString()
                }
            }
            viewModel.updateContinent(continentText)
        }
    }

    /**
     * Set next button
     * 이 메서드로 next button을 선택된 버튼이 있는지에 따라 활성화 비활성화
     * focused button이 nullable 타입이지만 예외를 만들지 않음
     */
    private fun setNextButton() {
        if (focusedButton != null) {
            binding.nextButton.apply {
                setBackgroundColor(
                    ContextCompat
                        .getColor(requireContext(), R.color.sky_blue_500)
                )
                isEnabled = true
            }
        } else {
            binding.nextButton.apply {
                setBackgroundColor(
                    ContextCompat
                        .getColor(requireContext(), R.color.gray_scale_300)
                )
                isEnabled = false
            }
        }
    }

    private fun initNextButton() {
        binding.nextButton.setOnAvoidDuplicateClick {
            findNavController().apply {
                navigate(R.id.action_countrySelectFragment_to_userInputFragment)
            }
        }
    }

    companion object {
        fun newInstance() = CountrySelectFragment()
    }

}