package com.poten.android.tripj.presentation.ui.home.community.detail

import android.os.Bundle
import android.view.View
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentPostDetailBinding
import com.poten.android.tripj.util.BaseFragment

class PostDetailFragment(

) : BaseFragment<FragmentPostDetailBinding>(FragmentPostDetailBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initToolbar() {
        binding.includedToolBar.titleTextView.text=getString(R.string.post_detail_fragment_title)

    }
}