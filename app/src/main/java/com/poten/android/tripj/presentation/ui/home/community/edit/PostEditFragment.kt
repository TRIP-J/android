package com.poten.android.tripj.presentation.ui.home.community.edit

import android.os.Bundle
import android.view.View
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentPostEditBinding
import com.poten.android.tripj.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostEditFragment(

): BaseFragment<FragmentPostEditBinding>(FragmentPostEditBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()
    }


    private fun initToolBar() {
        with(binding) {
            includedToolBar.titleTextView.text=getString(R.string.post_edit_fragment_title)
            includedToolBar.enrollTextView.text=getString(R.string.post_edit_fragment_enroll)
        }
    }
}