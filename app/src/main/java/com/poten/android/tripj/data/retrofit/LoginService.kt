package com.poten.android.tripj.data.retrofit

import com.poten.android.tripj.data.model.login.OauthRequest
import com.poten.android.tripj.data.model.login.OauthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface LoginService {

    @POST("oauth/login")
    @Headers("Content-Type:application/json")
    suspend fun oauthLogin(
        @Header("Authorization") accessToken: String,
        @Body requestBody: OauthRequest
    ): Response<OauthResponse>

}