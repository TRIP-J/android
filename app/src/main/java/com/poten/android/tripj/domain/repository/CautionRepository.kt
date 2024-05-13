package com.poten.android.tripj.domain.repository

import com.poten.android.tripj.data.model.CautionDetailResponse
import com.poten.android.tripj.data.model.CautionListResponse
import retrofit2.Response

interface CautionRepository {

    suspend fun getAllCaution(countryId: Int) : Response<CautionListResponse>

    suspend fun getCaution(cautionId: Int) : Response<CautionDetailResponse>

}