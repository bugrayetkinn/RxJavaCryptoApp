package com.yetkin.rxjavacryptoapp.module

import com.yetkin.rxjavacryptoapp.data.repository.CryptoRepository
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val cryptoRepositoryModule = module {
    single { CryptoRepository(get()) }
}