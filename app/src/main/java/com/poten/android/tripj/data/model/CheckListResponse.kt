package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("itemId")
    val itemId:Int,
    @SerializedName("itemName")
    val itemName:String,
    @SerializedName("itemCateName")
    val itemCateName:String,
)

data class CategoryItemsResponse(
    @SerializedName("data")
    val data:List<CategoryResponse>
)

// 체크리스트 삭제 Response
data class CheckListAddDeleteResponse(
    @SerializedName("checkListId")
    val checkListId:Int,
)

// 체크리스트에 담은 Item 조회 Response
data class CheckListResponse(
    @SerializedName("checkListId")
    val checkListId: Int,
    @SerializedName("itemName")
    val itemName: String,
    @SerializedName("itemCateName")
    val itemCateName: String,
    @SerializedName("tripName")
    val tripName:String,
    @SerializedName("pack")
    val pack:String,
)

data class CheckListItemResponse(
    @SerializedName("data")
    val data:List<CheckListResponse>
)

// 챙김 여부 변경 시 Response
data class CheckListRenewResponse(
    @SerializedName("id")
    val id:Int,
    @SerializedName("pack")
    val pack:String,
)

