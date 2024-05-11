package com.poten.android.tripj.presentation.uistate.select

import android.os.Build.VERSION_CODES.M
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poten.android.tripj.data.model.trip.GetTripResponse
import com.poten.android.tripj.data.model.trip.PostTripResponse
import com.poten.android.tripj.data.model.trip.TripHistory
import com.poten.android.tripj.data.model.trip.TripRequest
import com.poten.android.tripj.domain.repository.TripRepository
import com.poten.android.tripj.util.Resource
import com.prolificinteractive.materialcalendarview.CalendarDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class TripViewModel @Inject constructor(
    private val repository: TripRepository
) : ViewModel() {

    // 여행 Id
    private val _tripId = MutableStateFlow<Resource<PostTripResponse>>(Resource.Loading())
    val tripId: StateFlow<Resource<PostTripResponse>> = _tripId.asStateFlow()

    private val _country = MutableStateFlow<String>("")
    val country = _country.asStateFlow()

    private val _countryId = MutableStateFlow<Int>(0)
    val countryId = _countryId.asStateFlow()

    private val _continent = MutableStateFlow<String>("")
    val continent = _continent.asStateFlow()

    private val _travelName = MutableStateFlow<String>("")
    val travelName = _travelName.asStateFlow()

    private val _startDate = MutableStateFlow<CalendarDay>(CalendarDay.today())
    val startDate = _startDate.asStateFlow()

    private val _endDate = MutableStateFlow<CalendarDay>(CalendarDay.today())
    val endDate = _endDate.asStateFlow()

    private val _travelDuration = MutableStateFlow<String>("여행 일정을 선택해주세요.")
    val travelDuration = _travelDuration.asStateFlow()

    private val _travelPurpose = MutableStateFlow<String>("여행 목적을 선택해주세요.")
    val travelPurpose = _travelPurpose.asStateFlow()

    // 여행 History
    private val _tripHistory = MutableStateFlow<Resource<TripHistory>>(Resource.Loading())
    val tripHistory: StateFlow<Resource<TripHistory>> = _tripHistory.asStateFlow()

    // 여행 1개
    private val _trip = MutableStateFlow<Resource<GetTripResponse>>(Resource.Loading())
    val trip: StateFlow<Resource<GetTripResponse>> = _trip.asStateFlow()


    fun updateCountry(country: String) {
        _country.value = country
    }

    fun updateCountryId(countryId: Int) {
        _countryId.value = countryId
    }


    fun updateContinent(continent: String) {
        _continent.value = continent
    }

    fun updateStartDate(startDate: CalendarDay) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(startDate.toString().substring(12).removePrefix("}"))
        _startDate.value = startDate
    }

    fun updateEndDate(endDate: CalendarDay) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(endDate.toString().substring(12).removePrefix("}"))
        _endDate.value = endDate
    }

    fun updateTravelPurpose(purpose: String) {
        _travelPurpose.value = purpose
    }

    fun updateTravelName(name: String) {
        _travelName.value = name
    }


    // 지난 여행기록 보기
    fun loadTripHistory(userId: Int) {
        viewModelScope.launch {
            _tripHistory.value = Resource.Loading()
            try {
                val response = repository.getTrips(userId)
                if (response.isSuccessful && response.body() != null) {
                    _tripHistory.value = Resource.Success(response.body()!!)
                } else {
                    _tripHistory.value =
                        Resource.Error(message = response.message() ?: "Unknown Error")
                }
            } catch (e: Exception) {
                _tripHistory.value = Resource.Error(message = e.message ?: "Unknown Error")

            }
        }
    }

    fun loadTrip(userId: Int) {
        viewModelScope.launch {
            _trip.value = Resource.Loading()
            try {
                val response = repository.getTrip(userId)
                if (response.isSuccessful && response.body() != null) {
                    _trip.value = Resource.Success(response.body()!!)
                } else {
                    _trip.value =
                        Resource.Error(message = response.message() ?: "Unknown Error")
                }
            } catch (e: Exception) {
                _trip.value = Resource.Error(message = e.message ?: "Unknown Error")
            }
        }
    }

    fun enrollTrip(userId: Int, request: TripRequest) {
        viewModelScope.launch {
            try {
                val response = repository.enrollTrip(userId, request)
                if (response.isSuccessful && response.body() != null) {
                    _tripId.value = Resource.Success(response.body()!!)
                } else {
                    _tripId.value = Resource.Error(message = response.message() ?: "Unknown Error")
                }
            } catch (e: Exception) {
                _tripId.value = Resource.Error(message = e.message ?: "Unknown Error")
            }
        }
    }

    fun updateTrip(tripId: Int, userId: Int, request: TripRequest) {
        viewModelScope.launch {
            try {
                val response = repository.updateTrip(tripId, userId, request)
                if (response.isSuccessful && response.body() != null) {
                    _tripId.value = Resource.Success(response.body()!!)
                } else {
                    _tripId.value = Resource.Error(message = response.message() ?: "Unknown Error")
                }
            } catch (e: Exception) {
                _tripId.value = Resource.Error(message = e.message ?: "Unknown Error")
            }
        }
    }
}