package com.poten.android.tripj.data.retrofit

import com.poten.android.tripj.data.model.GetTripResponse
import com.poten.android.tripj.data.model.PostTripResponse
import com.poten.android.tripj.data.model.TripHistory
import com.poten.android.tripj.data.model.TripRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TripService {
    // 여행 등록
    @POST("/trip")
    suspend fun enrollTrip(
        @Query("userId") userId: Int,
        @Body tripRequest: TripRequest
    ): Response<PostTripResponse>


    // 여행 조회 (여행 1개 조회)
    @GET("/trip")
    suspend fun getTrip(@Query("userId") userId: Int): Response<GetTripResponse>


    // 여행 수정
    @POST("/trip/{tripId}")
    suspend fun updateTrip(
        @Path("tripId") tripId: Int,
        @Query("userId") userId:Int,
        @Body tripRequest: TripRequest
    ) : Response<PostTripResponse>


    // 지난 여행 기록 조회 (전체)
    @GET("trip/past")
    suspend fun getTripHistory(
        @Query("userId") userId: Int,
    ) : Response<TripHistory>
}