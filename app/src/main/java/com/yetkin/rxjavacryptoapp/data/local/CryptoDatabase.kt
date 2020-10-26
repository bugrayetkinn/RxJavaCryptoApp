package com.yetkin.rxjavacryptoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yetkin.rxjavacryptoapp.data.model.CryptoModel


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

@Database(entities = [CryptoModel::class], version = 1, exportSchema = false)
abstract class CryptoDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao
}