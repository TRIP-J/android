package com.poten.android.tripj.presentation.uistate.select

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectViewModel : ViewModel() {

    private val _selectStep= MutableStateFlow<Int>(0)
    val selectStep=_selectStep.asStateFlow()

    private val _country= MutableStateFlow<String>("")
    val country=_country.asStateFlow()

    private val _continent= MutableStateFlow<String>("")
    val continent=_continent.asStateFlow()

    private val _travelName= MutableStateFlow<String>("")
    val travelName=_travelName.asStateFlow()

    private val _travelDuration= MutableStateFlow<String>("")
    val travelDuration=_travelDuration.asStateFlow()

    private val _travelPurpose= MutableStateFlow<String>("")
    val travelPurpose=_travelPurpose.asStateFlow()

    fun updateCountry(country: String) {
        _country.value=country
    }

    fun updateContinent(continent: String) {
        _continent.value=continent
    }




    fun next() {
        _selectStep.value+=1
    }

    fun before() {
        _selectStep.value+=1
    }
}