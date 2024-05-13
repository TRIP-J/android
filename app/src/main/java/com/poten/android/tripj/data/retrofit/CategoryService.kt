package com.poten.android.tripj.data.retrofit

import com.poten.android.tripj.data.model.CheckListAddDeleteResponse
import com.poten.android.tripj.data.model.CheckListAddRequest
import com.poten.android.tripj.data.model.CheckListItemResponse
import com.poten.android.tripj.data.model.CheckListRenewResponse
import com.poten.android.tripj.data.model.CheckListRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryService {

    @GET("checklist")
    suspend fun checkCategoryItem(
        @Query("itemCateId") itemCateId:Int,
        @Query("userId") userId:Int,
        @Query("countryId") countryId:Int,
    ) : Response<CheckListItemResponse>

    @POST
    suspend fun addCheckListItem(
        @Query("userId") userId: Int,
        @Body checkListAddRequest: CheckListAddRequest
    ) : Response<CheckListAddDeleteResponse>

    // 체크 리스트에서 삭제
    @DELETE("checklist/{checklistId}")
    suspend fun deleteCheckListItem(
        @Path("checkListId") checkListId:Int,
        @Query("userId") userId: Int,
    ) : Response<CheckListAddDeleteResponse>


    // 체크리스트에 담은 아이템 조회
    @GET("checklist/added")
    suspend fun checkContainedItem(
        @Query("itemCateId") itemCateId: Int,
        @Query("userId") userId: Int,
        @Query("tripId") tripId:Int,
    ) : Response<CheckListItemResponse>

    // 체크리스트 체크 여부 조정
    @POST("checklist/pack")
    suspend fun changeContainedStatus(
        @Query("userId") userId: Int,
        @Body checkListRequest: CheckListRequest
    ) : Response<CheckListRenewResponse>

}