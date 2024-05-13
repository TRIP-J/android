package com.poten.android.tripj.presentation.uistate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poten.android.tripj.data.model.OauthRequest
import com.poten.android.tripj.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

    private val _loginStatus=MutableStateFlow<Boolean>(false)
    val loginStatus=_loginStatus.asStateFlow()

    fun login(accessToken:String, request: OauthRequest) {
        viewModelScope.launch {
            _loginStatus.value=repository.requestLogin(accessToken,request)!=null
        }
    }

}
