package com.poten.android.tripj.data.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate


data class GetCountryResponse(
    @SerializedName("countryName")
    val countryName:String,
    @SerializedName("countryId")
    val countryId:Int,
)


data class PostTripResponse(
    @SerializedName("tripId")
    val tripId:Int,
)

data class GetTripResponse(
    @SerializedName("tripId")
    val tripId:Int,
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("countryName")
    val countryName:String,
    @SerializedName("tripName")
    val tripName:String,
    @SerializedName("purpose")
    val purpose:Int,
    @SerializedName("startDate")
    val startDate:LocalDate,
    @SerializedName("endDate")
    val endDate:LocalDate,
)

data class TripHistory(
    @SerializedName("data")
    val data:List<GetTripResponse>
)
