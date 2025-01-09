package com.tenday.network.di

import com.tenday.network.retrofit.HandsUpDataSource
import com.tenday.network.retrofit.HandsUpService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class NetworkModule {

    @Binds
    abstract fun bindsHandsUpDataSource(
        impl: HandsUpService
    ): HandsUpDataSource

}