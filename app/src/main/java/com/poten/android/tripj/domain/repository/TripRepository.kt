package com.poten.android.tripj.domain.repository

import com.poten.android.tripj.data.model.GetTripResponse
import com.poten.android.tripj.data.model.PostTripResponse
import com.poten.android.tripj.data.model.TripHistory
import com.poten.android.tripj.data.model.TripRequest
import retrofit2.Response

interface TripRepository {
    suspend fun getTrips(userId:Int): Response<TripHistory>

    suspend fun getTrip(userId:Int) : Response<GetTripResponse>

    suspend fun enrollTrip(userId: Int, request: TripRequest) : Response<PostTripResponse>

    suspend fun updateTrip(tripId:Int, userId:Int, request: TripRequest) : Response<PostTripResponse>

}


