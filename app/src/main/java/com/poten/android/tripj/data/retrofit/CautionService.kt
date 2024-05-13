package com.poten.android.tripj.data.retrofit

import com.poten.android.tripj.data.model.CautionDetailResponse
import com.poten.android.tripj.data.model.CautionListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CautionService {
    @GET("precaution")
    suspend fun getAllCaution(@Query("countryId") countryId: Int): Response<CautionListResponse>

    @GET("precaution/{precautionId}")
    suspend fun getCautionDetail(
        @Path("precautionId") cautionId: Int
    ): Response<CautionDetailResponse>
}