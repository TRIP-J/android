package com.poten.android.tripj.data.retrofit

import com.poten.android.tripj.data.model.OauthRequest
import com.poten.android.tripj.data.model.OauthResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface LoginService {

    @POST("api/oauth/login")
    @Headers("Content-Type:application/json")
    suspend fun socialLogin(
        @Header("Authorization") accessToken: String,
        @Body requestBody: OauthRequest
    ): Response<OauthResponse>

}