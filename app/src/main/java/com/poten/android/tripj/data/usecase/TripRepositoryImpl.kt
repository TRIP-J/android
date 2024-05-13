package com.poten.android.tripj.data.usecase

import com.poten.android.tripj.data.model.GetTripResponse
import com.poten.android.tripj.data.model.PostTripResponse
import com.poten.android.tripj.data.model.TripHistory
import com.poten.android.tripj.data.model.TripRequest
import com.poten.android.tripj.data.retrofit.TripService
import com.poten.android.tripj.domain.repository.TripRepository
import retrofit2.Response
import javax.inject.Inject

class TripRepositoryImpl @Inject constructor(private val service: TripService) : TripRepository {

    // 여행 기록들 조회
    override suspend fun getTrips(userId: Int): Response<TripHistory> {
        return service.getTripHistory(userId)
    }

    // 여행 기록 1개 조회
    override suspend fun getTrip(userId: Int): Response<GetTripResponse> {
        return service.getTrip(userId)
    }

    override suspend fun enrollTrip(userId: Int, request: TripRequest): Response<PostTripResponse> {
        return service.enrollTrip(userId, request)
    }

    override suspend fun updateTrip(
        tripId: Int,
        userId: Int,
        request: TripRequest
    ): Response<PostTripResponse> {
        return service.updateTrip(tripId, userId, request)
    }

}