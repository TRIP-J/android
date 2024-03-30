package com.poten.android.tripj.domain.repository

import com.poten.android.tripj.data.retrofit.LoginService
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val service : LoginService) : LoginRepository {
    override suspend fun login() {
        service.snsLogin()
    }
}

