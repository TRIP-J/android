package com.poten.android.tripj.presentation.ui.home.mytrip.tips.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.poten.android.tripj.presentation.ui.home.community.home.PostFragment
import com.poten.android.tripj.presentation.ui.home.mytrip.tips.ConversationTipFragment

class ConversationTipViewPager(
    private val fragment: ConversationTipFragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0->{
                return PostFragment()
            }

            1->{
                return PostFragment()
            }

            2->{
                return PostFragment()
            }

            3->{
                return PostFragment()
            }

            4->{
                return PostFragment()
            }

            else->{
                return PostFragment()
            }
        }
    }

}