package com.poten.android.tripj.domain.repository


import com.poten.android.tripj.data.model.login.OauthRequest
import com.poten.android.tripj.data.model.login.OauthResponse
import retrofit2.Response

interface LoginRepository {
    suspend fun requestLogin(accessToken: String, request: OauthRequest)
            : OauthResponse?
}