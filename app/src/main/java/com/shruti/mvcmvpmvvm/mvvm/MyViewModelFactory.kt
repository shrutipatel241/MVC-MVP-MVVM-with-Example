package com.shruti.mvcmvpmvvm.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class MyViewModelFactory(private val repository: QuotesRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(repository) as T
    }

}