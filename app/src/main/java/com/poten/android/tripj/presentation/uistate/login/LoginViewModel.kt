package com.poten.android.tripj.presentation.uistate.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poten.android.tripj.data.model.OauthRequest
import com.poten.android.tripj.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

    suspend fun login(accessToken:String, request:OauthRequest) {
        viewModelScope.launch {
            val response=repository.requestLogin(accessToken, request)
            Log.e("LoginViewModel",response.toString())
        }
    }

}
