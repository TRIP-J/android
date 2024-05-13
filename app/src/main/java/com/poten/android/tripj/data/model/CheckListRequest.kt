package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName

data class CheckListAddRequest(
    @SerializedName("itemId")
    val itemId:Int,
    @SerializedName("tripId")
    val tripId:Int,
)

data class CheckListRequest(
    @SerializedName("checklistId")
    val checklistId: Int,
    @SerializedName("pack")
    val pack: String,
)