package com.poten.android.tripj.data.di

import com.poten.android.tripj.data.retrofit.BoardService
import com.poten.android.tripj.data.retrofit.CategoryService
import com.poten.android.tripj.data.retrofit.CautionService
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
    fun provideTripService(retrofit: Retrofit): TripService {
        return retrofit.create(TripService::class.java)
    }

    @Provides
    @Singleton
    fun provideCautionService(retrofit: Retrofit): CautionService {
        return retrofit.create(CautionService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryService(retrofit: Retrofit): CategoryService {
        return retrofit.create(CategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideBoardService(retrofit: Retrofit) : BoardService {
        return retrofit.create(BoardService::class.java)
    }
}