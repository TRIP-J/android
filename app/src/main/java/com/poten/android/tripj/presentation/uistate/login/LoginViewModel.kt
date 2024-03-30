package com.poten.android.tripj.presentation.uistate.login

import androidx.lifecycle.ViewModel
import com.poten.android.tripj.domain.repository.LoginRepository
import com.poten.android.tripj.domain.repository.LoginRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    suspend fun login() {
        repository.login()
    }

}