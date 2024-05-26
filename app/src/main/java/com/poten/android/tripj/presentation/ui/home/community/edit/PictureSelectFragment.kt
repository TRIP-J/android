package com.poten.android.tripj.presentation.ui.home.community.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.poten.android.tripj.databinding.FragmentPictureSelectBinding
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class PictureSelectFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentPictureSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentPictureSelectBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initCameraButton()
        initGalleryButton()
        initCancel()
    }

    private fun initCameraButton() {
        binding.takePictureButton.setOnAvoidDuplicateClick {
            // 카메라 앱 연동
        }
    }

    private fun initGalleryButton() {
        binding.getAlbumButton.setOnAvoidDuplicateClick {
            // 갤러리 앱 연동
        }
    }

    private fun initCancel() {
        binding.cancelButton.setOnAvoidDuplicateClick {
            dismiss()
        }
    }


}