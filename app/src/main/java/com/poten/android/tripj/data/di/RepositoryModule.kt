package com.poten.android.tripj.data.di

import com.poten.android.tripj.data.retrofit.BoardService
import com.poten.android.tripj.data.retrofit.CategoryService
import com.poten.android.tripj.data.retrofit.CautionService
import com.poten.android.tripj.data.retrofit.LoginService
import com.poten.android.tripj.data.retrofit.TripService
import com.poten.android.tripj.data.usecase.BoardRepositoryImpl
import com.poten.android.tripj.data.usecase.CategoryRepositoryImpl
import com.poten.android.tripj.data.usecase.CautionRepositoryImpl
import com.poten.android.tripj.data.usecase.LoginRepositoryImpl
import com.poten.android.tripj.data.usecase.TripRepositoryImpl
import com.poten.android.tripj.domain.repository.BoardRepository
import com.poten.android.tripj.domain.repository.CategoryRepository
import com.poten.android.tripj.domain.repository.CautionRepository
import com.poten.android.tripj.domain.repository.LoginRepository
import com.poten.android.tripj.domain.repository.TripRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

    @Provides
    fun provideCautionRepository(cautionService: CautionService) : CautionRepository {
        return CautionRepositoryImpl(cautionService)
    }

    @Provides
    fun provideCategoryRepository(categoryService: CategoryService) : CategoryRepository {
        return CategoryRepositoryImpl(categoryService)
    }

    @Provides
    fun provideBoardRepository(boardService: BoardService) : BoardRepository {
        return BoardRepositoryImpl(boardService)
    }
}