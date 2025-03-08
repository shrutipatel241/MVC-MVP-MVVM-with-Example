package com.shruti.mvcmvpmvvm.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
class QuoteModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String,
    val author:String
)