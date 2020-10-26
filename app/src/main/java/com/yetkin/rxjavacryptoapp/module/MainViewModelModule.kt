package com.yetkin.rxjavacryptoapp.module

import com.yetkin.rxjavacryptoapp.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val mainViewModelModule = module {

    viewModel { MainViewModel(get()) }
}