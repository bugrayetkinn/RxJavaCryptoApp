package com.yetkin.rxjavacryptoapp.data.repository

import com.yetkin.rxjavacryptoapp.ServiceInfo
import com.yetkin.rxjavacryptoapp.data.local.CryptoDao
import com.yetkin.rxjavacryptoapp.data.model.CryptoModel
import com.yetkin.rxjavacryptoapp.data.network.CryptoAPI


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoRepository(
    private val cryptoAPI: CryptoAPI,
    private val cryptoDao: CryptoDao
) {

    fun getAllCryptoFromApi() = cryptoAPI.getAllCryptoFromApi(ServiceInfo.KEY)


    fun insertAllCryptoFromDb(list: List<CryptoModel>) = cryptoDao.insertAll(list)

    fun getAllCryptoFromDb() = cryptoDao.getAll()

    fun deleteAllCrypto() = cryptoDao.deleteAll()
}