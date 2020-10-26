package com.yetkin.rxjavacryptoapp.data.network

import com.yetkin.rxjavacryptoapp.data.model.CryptoModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface CryptoAPI {

    @GET("prices")
    fun getAllCrypto(@Query("key") key: String): Single<List<CryptoModel>>
}