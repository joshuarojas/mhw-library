package com.samuelchowi.data.di

import com.samuelchowi.data.local.preferences.ThemePreferences
import com.samuelchowi.data.local.preferences.impl.ThemePreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {
    @Binds
    @Singleton
    abstract fun providesThemePreferences(themePreferencesImpl: ThemePreferencesImpl): ThemePreferences
}