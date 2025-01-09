package com.tenday.core.data.di

import com.tenday.core.data.repository.LoginRepositoryImpl
import com.tenday.core.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataModule {

    @Binds
    abstract fun bindsLoginRepository(
        impl: LoginRepositoryImpl
    ): LoginRepository

}