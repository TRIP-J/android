package com.poten.android.tripj.presentation.ui.home.community.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.poten.android.tripj.R
import com.poten.android.tripj.databinding.FragmentSubjectBinding
import com.poten.android.tripj.presentation.ui.adapter.SubjectAdapter
import com.poten.android.tripj.util.setOnAvoidDuplicateClick

class SubjectBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSubjectBinding
    private var itemList = emptyList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemList = resources.getStringArray(R.array.post_subject_list).toList()

        val subjectAdapter = SubjectAdapter(itemList) {
            // ViewModel의 데이터 갱신
        }

        initRecyclerView(subjectAdapter)
        initXImage()
    }

    private fun initRecyclerView(myAdapter: SubjectAdapter) {
        with(binding) {
            recyclerView.apply {
                adapter = myAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    private fun initXImage() {
        binding.xImageView.setOnAvoidDuplicateClick {
            this@SubjectBottomSheetFragment.dismiss()
        }
    }
}