package com.poten.android.tripj.presentation.ui.select

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.databinding.FragmentUserNicknameBinding
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class UserNicknameFragment : BaseFragment<FragmentUserNicknameBinding>(
    FragmentUserNicknameBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNextButton()
    }


    private fun initNextButton() {
        binding.nextButton.setOnAvoidDuplicateClick {
            findNavController()
                .navigate(
                    UserNicknameFragmentDirections
                        .actionUserNicknameFragmentToCountrySelectFragment()
                )

        }
    }

}