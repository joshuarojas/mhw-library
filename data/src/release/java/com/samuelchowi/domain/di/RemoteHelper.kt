package com.samuelchowi.domain.di

import okhttp3.logging.HttpLoggingInterceptor

object RemoteHelper {
    val loggingLevel = HttpLoggingInterceptor.Level.NONE
}