package com.poten.android.tripj.data.usecase


import com.poten.android.tripj.data.model.OauthRequest
import com.poten.android.tripj.data.model.OauthResponse
import com.poten.android.tripj.data.retrofit.LoginService
import com.poten.android.tripj.domain.repository.LoginRepository
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val service: LoginService) : LoginRepository {
    override suspend fun requestLogin(
        accessToken: String,
        request: OauthRequest,
    ): Response<OauthResponse> {
        return service.socialLogin(accessToken, request)
    }

}

