package com.shruti.mvcmvpmvvm.mvvm

import androidx.lifecycle.LiveData

class QuotesRepository(private val quoteDao: QuoteDao) {

    fun getQuotes():LiveData<List<QuoteModel>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuotes(quoteModel: QuoteModel){
        return quoteDao.insertQuote(quoteModel)
    }

}