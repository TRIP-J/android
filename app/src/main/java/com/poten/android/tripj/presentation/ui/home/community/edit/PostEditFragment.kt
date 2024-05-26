package com.poten.android.tripj.presentation.ui.home.community.edit

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentPostEditBinding
import com.poten.android.tripj.util.BaseFragment
import com.poten.android.tripj.util.closeKeyboard
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import com.poten.android.tripj.util.setOnEditorActionListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostEditFragment(

) : BaseFragment<FragmentPostEditBinding>(FragmentPostEditBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()
        initBackPress()
        initSubjectChooseTextView()
        initPostTitleEditText()
        initPostContentEditText()
        addPicture()

    }


    private fun initToolBar() {
        with(binding) {
            includedToolBar.titleTextView.text = getString(R.string.post_edit_fragment_title)
            includedToolBar.enrollTextView.text = getString(R.string.post_edit_fragment_enroll)
        }
    }

    private fun initBackPress() {
        binding.includedToolBar.backImageView.setOnAvoidDuplicateClick {
            findNavController().popBackStack()
        }
    }

    private fun initSubjectChooseTextView() {
        with(binding) {
            subjectTextView.setOnAvoidDuplicateClick {
                SubjectBottomSheetFragment().show(childFragmentManager, null)
            }
        }
    }

    private fun initPostTitleEditText() {
        binding.postTitleEditText.apply {
            doAfterTextChanged {

            }

            setOnEditorActionListener(EditorInfo.IME_ACTION_DONE) {
                binding.postTitleEditText.also {
                    it.clearFocus()
                    it.closeKeyboard()
                }

            }
        }
    }

    private fun initPostContentEditText() {
        binding.postContentEditText.apply {
            doAfterTextChanged {
                // TODO ViewModel 갱신 및 글씨 폰트 바꾸기
            }

            setOnEditorActionListener(EditorInfo.IME_ACTION_DONE) {
                binding.postContentEditText.also {
                    it.clearFocus()
                    it.closeKeyboard()
                }

            }
        }
    }

    private fun addPicture() {
        binding.addPictureTextView.setOnAvoidDuplicateClick {
            // Gallery에서 사진 가져오기 or 카메라앱에서 찍은 사진 연동 (다이얼로그 보여주기)
            PictureSelectFragment().show(childFragmentManager, null)
        }
    }
}