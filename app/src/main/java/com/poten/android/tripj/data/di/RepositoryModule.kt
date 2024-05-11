package com.poten.android.tripj.data.di

import com.poten.android.tripj.data.retrofit.LoginService
import com.poten.android.tripj.data.retrofit.TripService
import com.poten.android.tripj.domain.repository.LoginRepository
import com.poten.android.tripj.data.usecase.LoginRepositoryImpl
import com.poten.android.tripj.data.usecase.TripRepositoryImpl
import com.poten.android.tripj.domain.repository.TripRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideLoginRepository(loginService: LoginService) : LoginRepository {
        return LoginRepositoryImpl(loginService)
    }

    @Provides
    fun provideTripRepository(tripService: TripService) : TripRepository {
        return TripRepositoryImpl(tripService)
    }
}