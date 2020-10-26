package com.yetkin.rxjavacryptoapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yetkin.rxjavacryptoapp.data.model.CryptoModel
import io.reactivex.rxjava3.core.Completable


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<CryptoModel>): Completable

    @Query("SELECT*FROM crypto")
    fun getAll(): LiveData<List<CryptoModel>>

    @Query("DELETE FROM crypto")
    fun deleteAll(): Completable

}