package com.poten.android.tripj.presentation.ui.home.community.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.poten.android.tripj.presentation.ui.home.community.CommunityHomeFragment
import com.poten.android.tripj.presentation.ui.home.community.home.PostFragment

// ViewPager 적용을 위한 Adapter
class ViewPagerAdapter(
    private val fragment:CommunityHomeFragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0-> {
                return PostFragment()
            }

            1-> {
                return PostFragment()
            }

            2-> {
                return PostFragment()
            }

            3-> {
                return PostFragment()
            }

            else-> {
                return PostFragment()
            }
        }
    }

}