package com.poten.android.tripj.presentation.ui.select

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentUserInputBinding
import com.poten.android.tripj.presentation.ui.select.bottom.CalendarFragment
import com.poten.android.tripj.presentation.ui.select.bottom.PurposeFragment
import com.poten.android.tripj.presentation.uistate.TripViewModel
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.closeKeyboard
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import com.poten.android.tripj.util.setOnEditorActionListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserInputFragment
    : BaseFragment<FragmentUserInputBinding>(FragmentUserInputBinding::inflate) {

    private val viewModel: TripViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        TODO : 2. 여행 기간 선택
        TODO : 모두 입력 받으면 선택 완료를 눌러 서버에 데이터 전송 (POST)
        -> 모두 입력 받아야 선택 완료 버튼이 활성화 되도록
         */
        initView()
        initBackPress()
        initNextButton()
        initTravelPurposeEditText()
        observeTravelName()
        observeTravelPurpose()

        with(binding) {
            travelDurationTextView.setOnAvoidDuplicateClick {
                CalendarFragment().show(childFragmentManager, null)
            }

            travelPurposeTextView.setOnAvoidDuplicateClick {
                PurposeFragment().show(childFragmentManager, null)
            }
        }
    }

    private fun initView() {
        with(binding) {
            travelPurposeTextView.text = getString(R.string.user_input_travel_purpose_hint)
            toolBar.titleTextView.text = ""
        }
    }

    private fun initBackPress() {
        binding.toolBar.backImageView.setOnAvoidDuplicateClick {
            findNavController().popBackStack()
        }
    }

    private fun initNextButton() {
        // 다음 Activity로 이동
        binding.nextButton.setOnAvoidDuplicateClick {
            /* TODO: Post로 서버에 여행 정보 전송 -> 데이터가 비어있거나 선택 안되었으면 버튼 비활성화*/
            findNavController().navigate(R.id.action_userInputFragment_to_myTripFragment)
        }
    }

    private fun initTravelPurposeEditText() {
        binding.travelNameEditText.apply{
            doAfterTextChanged { name->
                viewModel.updateTravelName(name.toString())
                changeNameFont(name.toString())
            }

            setOnEditorActionListener(EditorInfo.IME_ACTION_DONE) {
                binding.travelNameEditText.clearFocus()
                binding.travelNameEditText.closeKeyboard()
            }
        }
    }

    private fun changeNameFont(name: String) {
        if (name.isNotEmpty()) {
            binding.travelNameEditText.typeface=ResourcesCompat.getFont(
                requireContext(),R.font.pretendard_semibold
            )
        }
    }

    private fun observeTravelName() {
        lifecycleScope.launch {
            viewModel.travelName.collect { name->
                binding.travelNameEditText.setText(name)
            }
        }
    }

    private fun observeTravelPurpose() {
        lifecycleScope.launch {
            viewModel.travelPurpose.collect { purpose ->
                binding.travelPurposeTextView.text = purpose
                // 초기 데이터만 색상 흐리게 사용자 입력을 받으면 바뀌도록
                if (purpose == getString(R.string.user_input_travel_purpose_hint)) {
                    binding.travelPurposeTextView.setTextColor(
                        ContextCompat.getColor(requireContext(), R.color.gray_scale_400)
                    )
                    binding.travelPurposeTextView.typeface = ResourcesCompat.getFont(
                        requireContext(), R.font.pretendard_medium
                    )
                } else {
                    binding.travelPurposeTextView.setTextColor(
                        ContextCompat.getColor(requireContext(), R.color.gray_scale_700)
                    )
                    binding.travelPurposeTextView.typeface = ResourcesCompat.getFont(
                        requireContext(), R.font.pretendard_semibold
                    )
                }
            }
        }
    }

    companion object {
        fun newInstance() = UserInputFragment()
    }
}