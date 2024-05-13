package com.poten.android.tripj.data.usecase

import com.poten.android.tripj.data.model.CautionDetailResponse
import com.poten.android.tripj.data.model.CautionListResponse
import com.poten.android.tripj.data.retrofit.CautionService
import com.poten.android.tripj.domain.repository.CautionRepository
import retrofit2.Response
import javax.inject.Inject

class CautionRepositoryImpl @Inject constructor(
    private val service : CautionService
) : CautionRepository {
    override suspend fun getAllCaution(countryId: Int): Response<CautionListResponse> {
        return service.getAllCaution(countryId)
    }

    override suspend fun getCaution(cautionId: Int): Response<CautionDetailResponse> {
        return service.getCautionDetail(cautionId)
    }
}