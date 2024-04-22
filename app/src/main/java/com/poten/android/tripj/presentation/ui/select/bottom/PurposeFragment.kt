package com.poten.android.tripj.presentation.ui.select.bottom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentPurposeBinding
import com.poten.android.tripj.presentation.ui.adapter.PurposeAdapter
import com.poten.android.tripj.presentation.uistate.select.SelectViewModel
import com.poten.android.tripj.util.closeKeyboard
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import com.poten.android.tripj.util.setOnEditorActionListener

class PurposeFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentPurposeBinding
    private val viewModel: SelectViewModel by activityViewModels()
    private var itemList = emptyList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPurposeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemList = resources.getStringArray(R.array.purpose_array).toList()

        // Item 선택 시 선택한 Item이 들어 가도록
        val purposeAdapter = PurposeAdapter(itemList) {
            viewModel.updateTravelPurpose(it)
            this@PurposeFragment.dismiss()
        }

        with(binding) {
            recyclerView.apply {
                adapter = purposeAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }

            xImageView.setOnAvoidDuplicateClick {
                this@PurposeFragment.dismiss()
            }

            // 직접 입력 시 직접 입력 한 데이터가 들어 가도록
            userInputEditText.setOnEditorActionListener(EditorInfo.IME_ACTION_DONE) {
                userInputEditText.clearFocus()
                viewModel.updateTravelPurpose(userInputEditText.text.toString())
                userInputEditText.closeKeyboard()
                this@PurposeFragment.dismiss()
            }
        }
    }
}