package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName


data class CautionResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("countryName")
    val countryName: String,
)

data class CautionListResponse(
    @SerializedName("data")
    val data : List<CautionResponse>
)

data class CautionDetailResponse(
    @SerializedName("title")
    val title:String,
    @SerializedName("content")
    val content:String
)