package com.poten.android.tripj.presentation.ui.home.mytrip.tips

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentConversationTipBinding
import com.poten.android.tripj.presentation.ui.home.mytrip.tips.adapter.ConversationTipViewPager
import com.poten.android.tripj.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConversationTipFragment
    : BaseFragment<FragmentConversationTipBinding>(FragmentConversationTipBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initTab()

    }

    private fun initViewPager() {
        binding.viewPager.adapter = ConversationTipViewPager(this)
    }

    private fun initTab() {
        val tabList = resources.getStringArray(R.array.conversation_tip_list).toList()

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabList[position].toString()
        }.attach()
    }

}