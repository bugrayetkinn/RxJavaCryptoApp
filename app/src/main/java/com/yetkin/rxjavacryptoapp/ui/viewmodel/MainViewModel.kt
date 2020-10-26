package com.yetkin.rxjavacryptoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yetkin.rxjavacryptoapp.data.model.CryptoModel
import com.yetkin.rxjavacryptoapp.data.repository.CryptoRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class MainViewModel(private val cryptoRepository: CryptoRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _cryptoListFromApi = MutableLiveData<List<CryptoModel>>()
    val cryptoListFromApi: LiveData<List<CryptoModel>>
        get() = _cryptoListFromApi

    val cryptoListFromDb: LiveData<List<CryptoModel>> = cryptoRepository.getAllCryptoFromDb()


    init {
        getAllCryptoFromApi()
    }


    private fun getAllCryptoFromApi() {
        deleteAllCrypto()
        compositeDisposable.add(
            cryptoRepository.getAllCryptoFromApi().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CryptoModel>>() {
                    override fun onSuccess(cryptoList: List<CryptoModel>?) {
                        _cryptoListFromApi.value = cryptoList
                        cryptoList?.let {
                            insertAllCryptoFromDb(it)
                        }
                    }

                    override fun onError(e: Throwable?) {
                    }
                })
        )
    }

    private fun insertAllCryptoFromDb(list: List<CryptoModel>) = compositeDisposable.add(
        cryptoRepository.insertAllCryptoFromDb(list).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                Log.e("Success", "INSERT")
            }, {
                Log.e("Error INSERT", "${it.message}")
            })
    )

    private fun deleteAllCrypto() =
        compositeDisposable.add(
            cryptoRepository.deleteAllCrypto().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    Log.e("Success", "DELETE")
                }, {
                    Log.e("Error DELETE", "${it.message}")
                })
        )

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}