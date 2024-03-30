package com.poten.android.tripj.data.di

import com.poten.android.tripj.data.retrofit.LoginService
import com.poten.android.tripj.domain.repository.LoginRepository
import com.poten.android.tripj.domain.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideLoginRepository(loginService: LoginService) : LoginRepository {
        return LoginRepositoryImpl(loginService)
    }
}