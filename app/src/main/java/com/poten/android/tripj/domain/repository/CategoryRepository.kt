package com.poten.android.tripj.domain.repository

import com.poten.android.tripj.data.model.CheckListAddDeleteResponse
import com.poten.android.tripj.data.model.CheckListAddRequest
import com.poten.android.tripj.data.model.CheckListItemResponse
import com.poten.android.tripj.data.model.CheckListRenewResponse
import com.poten.android.tripj.data.model.CheckListRequest
import retrofit2.Response

interface CategoryRepository {

    suspend fun getCategoryItem(
        itemCateId: Int,
        userId: Int,
        countryId: Int,
    ): Response<CheckListItemResponse>

    suspend fun addItem(
        userId: Int,
        checkListAddRequest: CheckListAddRequest
    ): Response<CheckListAddDeleteResponse>

    suspend fun deleteItem(
        checkListId:Int,
        userId : Int,
    ) : Response<CheckListAddDeleteResponse>

    suspend fun readItemList(
        itemCateId:Int,
        userId:Int,
        tripId:Int,
    ) : Response<CheckListItemResponse>


    suspend fun renewItemStatus(
        userId:Int,
        checkListRequest:CheckListRequest
    ) : Response<CheckListRenewResponse>
}