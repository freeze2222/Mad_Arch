package com.local.oech_2f.data.utils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RetrofitProvider {
    @Singleton
    @Provides
    fun provideRetrofit(): OECHApi {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OECHApi::class.java)
    }
}

@InstallIn(SingletonComponent::class)
@Module
object ConstantsProvider {
    @Singleton
    @Provides
    fun provideConstants(): ConstantsApi {
        return ConstantsApiImpl()
    }
}