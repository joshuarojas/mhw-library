package com.samuelchowi.data.di

import com.samuelchowi.data.repository.UIThemeRepositoryImpl
import com.samuelchowi.domain.repository.UIThemeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
    @Binds
    @ViewModelScoped
    abstract fun providesUIThemeRepository(uiThemeRepositoryImpl: UIThemeRepositoryImpl): UIThemeRepository
}