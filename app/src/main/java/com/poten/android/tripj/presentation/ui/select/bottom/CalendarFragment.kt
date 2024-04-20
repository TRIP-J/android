package com.poten.android.tripj.presentation.ui.select.bottom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.poten.android.tripj.databinding.FragmentCalendarBinding
import com.poten.android.tripj.presentation.uistate.select.SelectViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay

class CalendarFragment : BottomSheetDialogFragment() {

    private val viewModel : SelectViewModel by activityViewModels()
    private lateinit var binding: FragmentCalendarBinding
    private var startDate: CalendarDay? = null
    private var endDate: CalendarDay? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDate()
    }

    private fun getDate() {
        binding.calendarView.setOnRangeSelectedListener { widget, dates ->
            if (dates.size == 1) {
                startDate = dates[0]
                endDate = dates[0]
            } else if (dates.size > 1) {
                startDate = dates[0]
                endDate = dates[dates.size - 1]
            }
            Log.e("TAG","${startDate.toString()} : ${endDate.toString()}")
            // ViewModel에 갱신
            setStartDate()
            setEndDate()
        }
    }

    private fun setStartDate() {
        viewModel.updateStartDate(startDate)
    }

    private fun setEndDate() {
        viewModel.updateEndDate(endDate)
    }
}