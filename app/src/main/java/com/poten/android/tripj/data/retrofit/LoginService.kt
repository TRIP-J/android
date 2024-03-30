package com.poten.android.tripj.data.retrofit

import retrofit2.http.GET


interface LoginService {
   @GET("kakao")
   suspend fun snsLogin()

}