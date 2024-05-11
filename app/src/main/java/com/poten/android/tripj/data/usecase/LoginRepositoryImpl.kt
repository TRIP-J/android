package com.poten.android.tripj.data.usecase


import com.poten.android.tripj.data.model.login.OauthRequest
import com.poten.android.tripj.data.model.login.OauthResponse
import com.poten.android.tripj.data.retrofit.LoginService
import com.poten.android.tripj.domain.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val service: LoginService) : LoginRepository {
    override suspend fun requestLogin(
        accessToken: String,
        request: OauthRequest,
    ): OauthResponse? {
        return withContext(Dispatchers.IO) {
            val response = service.oauthLogin(accessToken, request)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }
}

