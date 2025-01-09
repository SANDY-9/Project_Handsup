package com.tenday.network.di

import com.tenday.network.BuildConfig
import com.tenday.network.retrofit.HandsUpServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun providesRequestInterceptor(): Interceptor = Interceptor {
        val url = it.request()
            .url
            .newBuilder()
            .build()
        val request = it.request()
            .newBuilder()
            .header("Content-Type", CONTENT_TYPE)
            .url(url)
            .build()
        return@Interceptor it.proceed(request)
    }

    @Provides
    @Singleton
    fun providesOkhttpClient(requestInterceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BASIC)
                }
            },
        )
        .callTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun providesHandsUpServiceApi(
        okHttpClient: OkHttpClient,
        networkJson: Json,
    ): HandsUpServiceApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(
                networkJson.asConverterFactory(CONTENT_TYPE.toMediaType()),
            )
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(HandsUpServiceApi::class.java)
    }

}

private const val NETWORK_TIME_OUT = 10L
private const val CONTENT_TYPE = "application/json"