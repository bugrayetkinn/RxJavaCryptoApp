package com.yetkin.rxjavacryptoapp.module

import com.yetkin.rxjavacryptoapp.ServiceInfo
import com.yetkin.rxjavacryptoapp.data.network.CryptoAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val cryptoClientModule = module {

    single {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        Retrofit.Builder()
            .baseUrl(ServiceInfo.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { get<Retrofit>().create(CryptoAPI::class.java) }
}