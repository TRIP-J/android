package com.poten.android.tripj.domain.repository


import com.poten.android.tripj.data.model.OauthRequest
import com.poten.android.tripj.data.model.OauthResponse
import retrofit2.Response

interface LoginRepository {
    suspend fun requestLogin(accessToken: String, request: OauthRequest): Response<OauthResponse>
}