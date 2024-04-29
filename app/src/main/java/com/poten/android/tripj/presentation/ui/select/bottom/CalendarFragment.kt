package com.poten.android.tripj.presentation.ui.select.bottom

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.poten.android.tripj.databinding.FragmentCalendarBinding
import com.poten.android.tripj.presentation.uistate.select.SelectViewModel
import com.poten.android.tripj.util.setOnAvoidDuplicateClick
import com.prolificinteractive.materialcalendarview.CalendarDay


class CalendarFragment : BottomSheetDialogFragment() {

    private val viewModel: SelectViewModel by activityViewModels()
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
        initExitButton()
        initCalendarView()

    }

    private fun getDate() {
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
        }
    }

    private fun initExitButton() {
        binding.calendarHeader.closeImageView.setOnAvoidDuplicateClick {
            dismiss()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initCalendarView() {
        // 상단 visibility 제거 및 년, 월 설정
        binding.calendarView.topbarVisible = false
        binding.calendarHeader.yearMonthTextView.text=getCalendarYearAndMonth()

        // 화살표 눌렀을 때 이벤트 처리
        setCalendarArrowImage()
        // 스와이프 했을 때 이벤트 처리
        setSwipeEvent()

//        binding.calendarView.addDecorator(CalendarDecorator(requireContext()))
    }

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

    private fun setSwipeEvent() {
        binding.calendarView.setOnMonthChangedListener {_,_->
            binding.calendarHeader.yearMonthTextView.text=getCalendarYearAndMonth()
        }
    }

    private fun getCalendarYearAndMonth() : String {
        var calendarHeaderText=""
        with(binding) {
            val year=calendarView.currentDate.year.toString()
            val month=calendarView.currentDate.month.toString()
            calendarHeaderText="${year}년 ${month}월"
        }
        return calendarHeaderText
    }

    private fun setStartDate() {
        viewModel.updateStartDate(startDate)
    }

    private fun setEndDate() {
        viewModel.updateEndDate(endDate)
    }
}