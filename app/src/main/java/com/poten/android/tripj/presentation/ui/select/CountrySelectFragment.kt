package com.poten.android.tripj.presentation.ui.select

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentCountrySelectBinding
import com.poten.android.tripj.presentation.uistate.TripViewModel
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.Country
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CountrySelectFragment
    : BaseFragment<FragmentCountrySelectBinding>(FragmentCountrySelectBinding::inflate) {

    private val viewModel: TripViewModel by activityViewModels()

    private var buttonList = listOf<Button>()

    private var focusedButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButtons()
        initView()
        initCountryButton()
        initNextButton()
        observeCountryButton()

        // TODO : 사용자 정보 받아와 이름 부분 연결 작업만 남았음
    }

    private fun initView() {
        binding.toolBar.apply {
            backImageView.visibility = View.INVISIBLE
            titleTextView.text = ""
        }
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

    // 여행하려는 국가의 대륙을 Mapping 하기 위한 메서드
    private fun setContinent() {
        viewLifecycleOwner.lifecycleScope.launch {
            var continentText = ""
            val countryEnum = Country.fromCountryName(focusedButton?.text.toString())
            when (countryEnum) {
                Country.JAPAN, Country.CHINA, Country.THAILAND, Country.HONGKONG -> {
                    continentText = binding.asiaTextView.text.toString()
                }

                Country.ENGLAND, Country.FRANCE, Country.ITALY -> {
                    continentText = binding.europeTextView.text.toString()
                }

                Country.USA, Country.CANADA, Country.ARGENTINA -> {
                    continentText = binding.americaTextView.text.toString()
                }

                else -> {}
            }
            viewModel.updateContinent(continentText)
            // CountryCode 값을 Enum의 ordinal을 활용하여 구성
            if (countryEnum != null) {
                viewModel.updateCountryId(countryEnum.ordinal + 1)
            }
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

    /**
     * Observe country button
     * 사용자가 기존에 선택한 Button을 유지하도록
     * @author harry
     */
    private fun observeCountryButton() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.country.collect { selectedCountryName ->
                buttonList.forEach { button ->
                    if (button.text == selectedCountryName) {
                        focusedButton = button
                        setNextButton()
                        button.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                        button.setBackgroundColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.sky_blue_500
                            )
                        )
                    }
                }
            }
        }
    }
}