package com.poten.android.tripj.presentation.uistate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poten.android.tripj.data.model.CautionDetailResponse
import com.poten.android.tripj.data.model.CautionListResponse
import com.poten.android.tripj.domain.repository.CautionRepository
import com.poten.android.tripj.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CautionViewModel @Inject constructor(
    private val repository: CautionRepository
) : ViewModel() {

    // 나라 별 주의 사항
    private val _cautionList = MutableStateFlow<Resource<CautionListResponse>>(Resource.Loading())
    val cautionList: StateFlow<Resource<CautionListResponse>> = _cautionList.asStateFlow()

    // 주의 사항 중 1개 선택했을 때
    private val _cautionDetail =
        MutableStateFlow<Resource<CautionDetailResponse>>(Resource.Loading())
    val cautionDetail = _cautionDetail.asStateFlow()


    fun getCautionList(countryId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getAllCaution(countryId)
                if (response.isSuccessful && response.body() != null) {
                    _cautionList.value = Resource.Success(response.body()!!)
                } else {
                    _cautionList.value =
                        Resource.Error(message = response.message() ?: "Unknown Error")
                }
            } catch (e: Exception) {
                _cautionList.value = Resource.Error(message = e.message ?: "Unknown Error")
            }
        }
    }

    fun getCautionDetail(cautionId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getCaution(cautionId)
                if (response.isSuccessful && response.body() != null) {
                    _cautionDetail.value = Resource.Success(response.body()!!)
                } else {
                    _cautionDetail.value =
                        Resource.Error(message = response.message() ?: "Unknown Error")
                }
            } catch (e: Exception) {
                _cautionDetail.value = Resource.Error(message = e.message ?: "Unknown Error")
            }
        }
    }


}