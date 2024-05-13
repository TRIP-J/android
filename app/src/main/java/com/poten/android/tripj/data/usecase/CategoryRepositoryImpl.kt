package com.poten.android.tripj.data.usecase

import com.poten.android.tripj.data.model.CheckListAddDeleteResponse
import com.poten.android.tripj.data.model.CheckListAddRequest
import com.poten.android.tripj.data.model.CheckListItemResponse
import com.poten.android.tripj.data.model.CheckListRenewResponse
import com.poten.android.tripj.data.model.CheckListRequest
import com.poten.android.tripj.data.retrofit.CategoryService
import com.poten.android.tripj.domain.repository.CategoryRepository
import retrofit2.Response
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val service: CategoryService
) : CategoryRepository {
    override suspend fun getCategoryItem(
        itemCateId: Int,
        userId: Int,
        countryId: Int
    ): Response<CheckListItemResponse> {
        return service.checkCategoryItem(itemCateId, userId, countryId)
    }

    override suspend fun addItem(
        userId: Int,
        checkListAddRequest: CheckListAddRequest
    ): Response<CheckListAddDeleteResponse> {
        return service.addCheckListItem(userId, checkListAddRequest)
    }

    override suspend fun deleteItem(
        checkListId: Int,
        userId: Int
    ): Response<CheckListAddDeleteResponse> {
        return service.deleteCheckListItem(checkListId, userId)
    }

    override suspend fun readItemList(
        itemCateId: Int,
        userId: Int,
        tripId: Int
    ): Response<CheckListItemResponse> {
        return service.checkContainedItem(itemCateId, userId, tripId)
    }

    override suspend fun renewItemStatus(
        userId: Int,
        checkListRequest: CheckListRequest
    ): Response<CheckListRenewResponse> {
        return service.changeContainedStatus(userId, checkListRequest)
    }


}