package com.samuelchowi.data.di

import com.samuelchowi.data.remote.MonsterAPI
import com.samuelchowi.data.remote.RemoteLanguage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun providesRetrofit(language: RemoteLanguage): Retrofit {
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = RemoteHelper.loggingLevel })
            .build()

        return Retrofit.Builder()
            .baseUrl("https://mhw-db.com/${language.getLanguage()}")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesMonsterApi(retrofit: Retrofit): MonsterAPI = retrofit.create(MonsterAPI::class.java)
}