package com.poten.android.tripj.presentation.ui.select

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentCountrySelectBinding
import com.poten.android.tripj.presentation.uistate.select.SelectViewModel
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class CountrySelectFragment
    : BaseFragment<FragmentCountrySelectBinding>(FragmentCountrySelectBinding::inflate) {

    private val viewModel : SelectViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            /*
             TODO 나라 선택 시 1개의 나라만 선택 가능 하고 선택된 나라와 대륙 연결
             */

            nextButton.setOnAvoidDuplicateClick {
                val navController=findNavController()
                navController.apply {
                    navigate(R.id.action_countrySelectFragment_to_userInputFragment)
                }
            }

        }
        /*
        TODO 나라 선택했는지 유효성 검사 후 선택 완료를 누르면 다음 Fragment로 넘어가도록
        -> 나라 선택 화면이 BackStack에 남아야한다
         */


    }

    companion object {
        fun newInstance()=CountrySelectFragment()
    }

}