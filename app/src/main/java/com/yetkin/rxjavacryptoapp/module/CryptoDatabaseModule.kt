package com.yetkin.rxjavacryptoapp.module

import androidx.room.Room
import com.yetkin.rxjavacryptoapp.data.local.CryptoDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val cryptoDatabaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            CryptoDatabase::class.java,
            "crypto.db"
        )
            .allowMainThreadQueries().build()
    }

    single { get<CryptoDatabase>().cryptoDao() }
}