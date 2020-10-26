package com.yetkin.rxjavacryptoapp

import android.app.Application
import com.yetkin.rxjavacryptoapp.module.cryptoClientModule
import com.yetkin.rxjavacryptoapp.module.cryptoDatabaseModule
import com.yetkin.rxjavacryptoapp.module.cryptoRepositoryModule
import com.yetkin.rxjavacryptoapp.module.mainViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                cryptoRepositoryModule,
                mainViewModelModule,
                cryptoClientModule,
                cryptoDatabaseModule
            )
        }
    }
}