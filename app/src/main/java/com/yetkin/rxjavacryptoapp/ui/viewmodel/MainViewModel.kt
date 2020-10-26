package com.yetkin.rxjavacryptoapp.ui.viewmodel

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
    private val _cryptos = MutableLiveData<List<CryptoModel>>()
    val cryptos: LiveData<List<CryptoModel>>
        get() = _cryptos


    init {
        getAllCrypto()
    }


    private fun getAllCrypto() = compositeDisposable.add(

        cryptoRepository.getAllCrypto().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<CryptoModel>>() {
                override fun onSuccess(t: List<CryptoModel>?) {
                    _cryptos.value = t
                }

                override fun onError(e: Throwable?) {
                }
            })
    )

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}