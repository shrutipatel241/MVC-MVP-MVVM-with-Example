package com.shruti.mvcmvpmvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(private val repository: QuotesRepository):ViewModel() {

    fun getQuotes():LiveData<List<QuoteModel>>{
        return repository.getQuotes()
    }

    fun insertQuotes(quoteModel: QuoteModel){
        viewModelScope.launch(Dispatchers.IO) {
             repository.insertQuotes(quoteModel)
        }
    }
}