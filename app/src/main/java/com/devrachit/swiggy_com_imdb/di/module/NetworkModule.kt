package com.devrachit.swiggy_com_imdb.di.module

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.devrachit.swiggy_com_imdb.data.remote.services.ApiServices
import com.devrachit.swiggy_com_imdb.di.qualifiers.WithChucker
import com.devrachit.swiggy_com_imdb.di.qualifiers.WithoutChucker
import com.devrachit.swiggy_com_imdb.utility.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @WithChucker
    fun provideOkHttpClientWithChucker(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .build()
    }

    @Provides
    @Singleton
    @WithoutChucker
    fun provideOkHttpClientWithoutChucker(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun providesApiServices(@WithChucker okhttpClient: OkHttpClient): ApiServices {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)

    }
}


