package com.poten.android.tripj.presentation.ui.select

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.poten.android.tripj.databinding.FragmentUserInputBinding
import com.poten.android.tripj.presentation.uistate.select.SelectViewModel
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class UserInputFragment
    : BaseFragment<FragmentUserInputBinding>(FragmentUserInputBinding::inflate) {

    private val viewModel: SelectViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /*
        TODO : 1. 여행 이름 입력, 2. 여행 기간 선택, 3. 여행 목적 선택
        TODO : 모두 입력 받으면 선택 완료를 눌러 서버에 데이터 전송 (POST)
        -> 모두 입력 받아야 선택 완료 버튼이 활성화 되도록
         */
        with(binding) {
            travelDurationLayout.setOnAvoidDuplicateClick {
                // TODO BottomSheet 올리기 (달력)

            }

            travelPurposeLayout.setOnAvoidDuplicateClick {
                // TODO BottomSheet 올리기 (여행 목적)

            }
        }

        Log.e("TAG","${viewModel.continent.value} and ${viewModel.country.value}")

    }

    companion object {
        fun newInstance() = UserInputFragment()
    }
}