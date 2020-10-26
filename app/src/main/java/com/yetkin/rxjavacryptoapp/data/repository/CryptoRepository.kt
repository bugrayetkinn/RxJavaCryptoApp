package com.yetkin.rxjavacryptoapp.data.repository

import com.yetkin.rxjavacryptoapp.ServiceInfo
import com.yetkin.rxjavacryptoapp.data.network.CryptoAPI


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoRepository(private val cryptoAPI: CryptoAPI) {

    fun getAllCrypto() = cryptoAPI.getAllCrypto(ServiceInfo.KEY)
}