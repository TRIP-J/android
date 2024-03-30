package com.poten.android.tripj.presentation.uistate.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poten.android.tripj.data.model.KakaoTokenResponse
import com.poten.android.tripj.domain.repository.LoginRepository
import com.poten.android.tripj.domain.repository.LoginRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {


    fun loginCallback(code: String, onResult: (Response<KakaoTokenResponse>) -> Unit) {
        viewModelScope.launch {
            val response= withContext(Dispatchers.IO) {
                repository.loginCallback(code)
            }
            onResult(response)
        }
    }
}
