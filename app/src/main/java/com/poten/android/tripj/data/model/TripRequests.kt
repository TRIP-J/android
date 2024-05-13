package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate


// 여행 등록 및 수정 시 Server에 전송 할 Body 형식
data class TripRequest(
    @SerializedName("tripName")
    val tripName:String,
    @SerializedName("purpose")
    val purpose:String,
    @SerializedName("previous")
    val previous:String,
    @SerializedName("startDate")
    val startDate:LocalDate,
    @SerializedName("endDate")
    val endDate:LocalDate,
    @SerializedName("countryId")
    val countryId:Int,
)

