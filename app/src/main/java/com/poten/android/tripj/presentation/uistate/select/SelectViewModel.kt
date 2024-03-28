package com.poten.android.tripj.presentation.uistate.select

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectViewModel : ViewModel() {

    private val _selectStep= MutableStateFlow<Int>(0)
    val selectStep=_selectStep.asStateFlow()

    private val _country= MutableStateFlow<String>("")
    val country=_country.asStateFlow()



    fun next() {
        _selectStep.value+=1
    }

    fun before() {
        _selectStep.value+=1
    }
}