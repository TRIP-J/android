package com.poten.android.tripj.presentation.ui.select.bottom

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.poten.android.tripj.databinding.FragmentCalendarBinding
import com.poten.android.tripj.presentation.uistate.TripViewModel
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import com.prolificinteractive.materialcalendarview.CalendarDay
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CalendarFragment : BottomSheetDialogFragment() {

    private val viewModel: TripViewModel by activityViewModels()
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
        initCalendarView()
        getRangeDate()
        initExitButton()
        observeStartDate()
    }

    /**
     * Get range date
     * 시작 일, 종료 일 가져오기
     */
    private fun getRangeDate() {
        binding.calendarView.setOnRangeSelectedListener { _, dates ->
            if (dates.size == 1) {
                startDate = dates[0]
                endDate = dates[0]
            } else if (dates.size > 1) {
                startDate = dates[0]
                endDate = dates[dates.size - 1]
            }

            Log.e("TAG", "${startDate.toString()} : ${endDate.toString()}")
            // ViewModel에 갱신
            setStartDate()
            setEndDate()
            updateDecorator()

        }
    }

    private fun observeStartDate() {
        lifecycleScope.launch {
            viewModel.startDate.collect {date->
                if (date.toString().isEmpty()) {
                    Log.e("TAG",date.toString())
                    clearDecorators()
                }
            }
        }
    }

    private fun updateDecorator() {
        binding.calendarView.removeDecorators()
        if (startDate != null && endDate != null) {
            binding.calendarView.addDecorator(StartEndDecorator(requireContext(),startDate!!,endDate!!))
            binding.calendarView.addDecorator(RangeDecorator(requireContext(), startDate!!, endDate!!))
            binding.calendarView.addDecorator(StartEdgeDecorator(requireContext(),startDate!!))
            binding.calendarView.addDecorator(EndEdgeDecorator(requireContext(),endDate!!))

        }
        binding.calendarView.invalidateDecorators()
    }

    private fun clearDecorators() {
        binding.calendarView.apply {
            removeDecorators()
            invalidateDecorators()
        }
    }

    // X 이미지 눌렀을 때 동작
    private fun initExitButton() {
        binding.calendarHeader.closeImageView.setOnAvoidDuplicateClick {
            dismiss()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun initCalendarView() {
        // 상단 visibility 제거 및 년, 월 설정
        binding.calendarView.topbarVisible = false
        binding.calendarHeader.yearMonthTextView.text = getCalendarYearAndMonth()
        binding.calendarView.setOnRangeSelectedListener { widget, dates ->

        }

        setCalendarArrowImage()
        setSwipeEvent()
    }



    // 화살표 눌렀을 때 이벤트 처리
    private fun setCalendarArrowImage() {
        with(binding) {
            calendarHeader.arrowBackImageView.setOnAvoidDuplicateClick {
                calendarView.goToPrevious()
                calendarHeader.yearMonthTextView.text = getCalendarYearAndMonth()
            }

            calendarHeader.arrowFrontImageView.setOnAvoidDuplicateClick {
                calendarView.goToNext()
                calendarHeader.yearMonthTextView.text = getCalendarYearAndMonth()
            }
        }
    }

    // 스와이프 했을 때 이벤트 처리
    private fun setSwipeEvent() {
        binding.calendarView.setOnMonthChangedListener { _, _ ->
            binding.calendarHeader.yearMonthTextView.text = getCalendarYearAndMonth()
        }
    }

    private fun getCalendarYearAndMonth(): String {
        var calendarHeaderText = ""
        with(binding) {
            val year = calendarView.currentDate.year.toString()
            val month = calendarView.currentDate.month.toString()
            calendarHeaderText = "${year}년 ${month}월"
        }
        return calendarHeaderText
    }

    // viewModel에 시작 일 갱신
    private fun setStartDate() {
        viewModel.updateStartDate(startDate!!)
    }

    // viewModel에 종료 일 갱신
    private fun setEndDate() {
        viewModel.updateEndDate(endDate!!)
    }
}