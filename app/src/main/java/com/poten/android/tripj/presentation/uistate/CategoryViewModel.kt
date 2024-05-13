package com.poten.android.tripj.presentation.uistate


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poten.android.tripj.data.model.CheckListAddDeleteResponse
import com.poten.android.tripj.data.model.CheckListAddRequest
import com.poten.android.tripj.data.model.CheckListItemResponse
import com.poten.android.tripj.data.model.CheckListRenewResponse
import com.poten.android.tripj.data.model.CheckListRequest
import com.poten.android.tripj.domain.repository.CategoryRepository
import com.poten.android.tripj.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    private val _itemList = MutableStateFlow<Resource<CheckListItemResponse>>(Resource.Loading())
    val itemList = _itemList.asStateFlow()

    private val _checkListId =
        MutableStateFlow<Resource<CheckListAddDeleteResponse>>(Resource.Loading())
    val checkListId = _checkListId.asStateFlow()

    // 지웠을 때 Response가 어떤 의미?

    private val _addedItem = MutableStateFlow<Resource<CheckListItemResponse>>(Resource.Loading())
    val addedItem = _addedItem.asStateFlow()

    private val _renewedItem =
        MutableStateFlow<Resource<CheckListRenewResponse>>(Resource.Loading())
    val renewedItem = _renewedItem.asStateFlow()

    private fun getAllItem(
        itemCateId: Int,
        userId: Int,
        countryId: Int
    ) {
        viewModelScope.launch {
            try {
                val response = repository.getCategoryItem(itemCateId, userId, countryId)
                if (response.isSuccessful && response.body() != null) {
                    _itemList.value = Resource.Success(response.body()!!)
                } else {

                }
            } catch (e: Exception) {

            }
        }
    }

    private fun addCategoryItem(
        userId: Int,
        checkListAddRequest: CheckListAddRequest
    ) {
        viewModelScope.launch {
            try {
                val response = repository.addItem(userId, checkListAddRequest)
                if (response.isSuccessful && response.body() != null) {
                    _checkListId.value = Resource.Success(response.body()!!)
                } else {

                }
            } catch (e: Exception) {

            }
        }
    }

    private fun getAddedItem(
        itemCateId: Int,
        userId: Int,
        tripId: Int,
    ) {
        viewModelScope.launch {
            try {
                val response = repository.readItemList(itemCateId, userId, tripId)
                if (response.isSuccessful && response.body() != null) {
                    _addedItem.value = Resource.Success(response.body()!!)
                } else {

                }
            } catch (e: Exception) {

            }
        }
    }

    private fun resetItem(
        userId: Int,
        checkListRequest: CheckListRequest
    ) {
        viewModelScope.launch {
            try {
                val response = repository.renewItemStatus(userId, checkListRequest)
                if (response.isSuccessful && response.body() != null) {
                    _renewedItem.value = Resource.Success(response.body()!!)
                } else {

                }
            } catch (e: Exception) {

            }
        }
    }

}