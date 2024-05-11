package com.poten.android.tripj.data.di

import com.poten.android.tripj.data.retrofit.LoginService
import com.poten.android.tripj.data.retrofit.TripService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Provides
    @Singleton
    fun provideTripService(retrofit: Retrofit) : TripService {
        return retrofit.create(TripService::class.java)
    }
}