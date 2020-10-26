package com.yetkin.rxjavacryptoapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yetkin.rxjavacryptoapp.R
import com.yetkin.rxjavacryptoapp.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.cryptos.observe(this, {
            Log.e("List:", "$it")
        })
    }
}