package com.poten.android.tripj.presentation.ui.select

import android.os.Bundle
import android.view.View
import com.poten.android.tripj.databinding.FragmentUserInputBinding
import com.poten.android.tripj.util.BaseFragment

class UserInputFragment
    : BaseFragment<FragmentUserInputBinding>(FragmentUserInputBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        TODO : 1. 여행 이름 입력, 2. 여행 기간 선택, 3. 여행 목적 선택
        TODO : 모두 입력 받으면 선택 완료를 눌러 서버에 데이터 전송 (POST)
         */

    }
}