package com.shruti.mvcmvpmvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuotes():LiveData<List<QuoteModel>>

    @Insert
    suspend fun insertQuote(quoteModel: QuoteModel)
}