package com.poten.android.tripj.presentation.ui.home.community

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentCommunityHomeBinding
import com.poten.android.tripj.presentation.ui.home.community.adapter.ViewPagerAdapter
import com.poten.android.tripj.util.BaseFragment

class CommunityHomeFragment :
    BaseFragment<FragmentCommunityHomeBinding>(FragmentCommunityHomeBinding::inflate) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initTab()
    }

    private fun initViewPager() {
        binding.viewPager.adapter=ViewPagerAdapter(this)
    }

    /**
     * Init tab
     * TabLayout 에 text 붙이기
     */
    private fun initTab() {
        val tabTextList= resources.getStringArray(R.array.community_fragment_home_tab).toList()

        TabLayoutMediator(binding.tabLayout,binding.viewPager) { tab, position->
            tab.text=tabTextList[position].toString()
        }.attach()
    }
}