package com.tenday.core.data.di

import com.tenday.core.data.repository.AuthPrefsRepositoryImpl
import com.tenday.core.data.repository.BoardListRepositoryImpl
import com.tenday.core.data.repository.ExpRepositoryImpl
import com.tenday.core.data.repository.LoginRepositoryImpl
import com.tenday.core.data.repository.MessagingTokenRepositoryImpl
import com.tenday.core.data.repository.NotificationRepositoryImpl
import com.tenday.core.data.repository.UserRepositoryImpl
import com.tenday.core.domain.repository.AuthPrefsRepository
import com.tenday.core.domain.repository.BoardListRepository
import com.tenday.core.domain.repository.ExpRepository
import com.tenday.core.domain.repository.LoginRepository
import com.tenday.core.domain.repository.MessagingTokenRepository
import com.tenday.core.domain.repository.NotificationRepository
import com.tenday.core.domain.repository.UserRepository
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

    @Binds
    abstract fun bindsAuthPrefsRepository(
        impl: AuthPrefsRepositoryImpl
    ): AuthPrefsRepository

    @Binds
    abstract fun bindsBoardListRepository(
        impl: BoardListRepositoryImpl
    ): BoardListRepository

    @Binds
    abstract fun bindsNotificationRepository(
        impl: NotificationRepositoryImpl
    ): NotificationRepository

    @Binds
    abstract fun bindsUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

    @Binds
    abstract fun bindsMessagingTokenRepository(
        impl: MessagingTokenRepositoryImpl
    ): MessagingTokenRepository

    @Binds
    abstract fun bindsExpRepository(
        impl: ExpRepositoryImpl
    ): ExpRepository

}