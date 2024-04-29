package com.poten.android.tripj.presentation.uistate.select

import androidx.lifecycle.ViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class SelectViewModel @Inject constructor(

) : ViewModel() {

    private val _country= MutableStateFlow<String>("")
    val country=_country.asStateFlow()

    private val _continent= MutableStateFlow<String>("")
    val continent=_continent.asStateFlow()

    private val _travelName= MutableStateFlow<String>("")
    val travelName=_travelName.asStateFlow()

    private val _startDate= MutableStateFlow<Date>(Date())
    val startDate=_startDate.asStateFlow()

    private val _endDate= MutableStateFlow<Date>(Date())
    val endDate=_endDate.asStateFlow()

    private val _travelDuration= MutableStateFlow<String>("여행 일정을 선택해주세요.")
    val travelDuration=_travelDuration.asStateFlow()

    private val _travelPurpose= MutableStateFlow<String>("여행 목적을 선택해주세요.")
    val travelPurpose=_travelPurpose.asStateFlow()

    fun updateCountry(country: String) {
        _country.value=country
    }

    fun updateContinent(continent: String) {
        _continent.value=continent
    }

    fun updateStartDate(startDate: CalendarDay?) {
        val dateFormat= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date=dateFormat.parse(startDate.toString().substring(12).removePrefix("}"))
        _startDate.value= date as Date
    }

    fun updateEndDate(endDate: CalendarDay?) {
        val dateFormat=SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date=dateFormat.parse(endDate.toString().substring(12).removePrefix("}"))
        _startDate.value= date as Date
    }

    fun updateTravelPurpose(purpose: String) {
        _travelPurpose.value=purpose
    }

    fun updateTravelName(name: String) {
        _travelName.value=name
    }
}