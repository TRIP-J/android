package com.poten.android.tripj.presentation.ui.home.mytrip

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.databinding.FragmentMyTripBinding
import com.poten.android.tripj.presentation.ui.home.mytrip.tips.CautionTipActivity
import com.poten.android.tripj.presentation.ui.home.mytrip.tips.ConversationTipActivity
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class MyTripFragment : BaseFragment<FragmentMyTripBinding>(FragmentMyTripBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        onNavigateToHistory()
        onNavigateToCountrySelect()
        getConversation()
        getCaution()
    }

    private fun onNavigateToHistory() {
        binding.showPreviousTripTextView.setOnAvoidDuplicateClick {
            findNavController()
                .navigate(
                    MyTripFragmentDirections
                        .actionMyTripFragmentToHistoryListFragment()
                )
        }
    }

    // 여행 정보 수정을 위한 화면 전환 (이전 화면 재사용 이므로 navGraph 하나로 합치는 방법 고려)
    private fun onNavigateToCountrySelect() {
        binding.tripInfoLayer.setOnAvoidDuplicateClick {
            findNavController()
                .navigate(
                    MyTripFragmentDirections.actionMyTripFragmentToCountrySelectFragment2()
                )
        }
    }

    private fun getConversation() {
        binding.conversationTipCardView.setOnAvoidDuplicateClick {
            (activity as AppCompatActivity)
                .startActivity(Intent(requireContext(), ConversationTipActivity::class.java))
        }
    }

    private fun getCaution() {
        binding.cautionTipCardView.setOnAvoidDuplicateClick {
            (activity as AppCompatActivity)
                .startActivity(Intent(requireContext(), CautionTipActivity::class.java))
        }
    }



}