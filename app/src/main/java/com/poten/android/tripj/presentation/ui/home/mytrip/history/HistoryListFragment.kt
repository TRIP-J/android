package com.poten.android.tripj.presentation.ui.home.mytrip.history

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.databinding.FragmentHistoryListBinding
import com.poten.android.tripj.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryListFragment :
    BaseFragment<FragmentHistoryListBinding>(FragmentHistoryListBinding::inflate) {

    // Adapter에 연결 할 메서드
    private lateinit var onClick: () -> Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick = { onNavigateToDetail() }
    }


    private fun onNavigateToDetail() {
        findNavController().navigate(
            HistoryListFragmentDirections.actionHistoryListFragmentToHistoryDetailFragment()
        )
    }

}