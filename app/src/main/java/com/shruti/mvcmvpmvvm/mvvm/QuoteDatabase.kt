package com.shruti.mvcmvpmvvm.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuoteModel::class], version = 3)
abstract class QuoteDatabase:RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, QuoteDatabase::class.java, "QuoteDatabase")
                            .createFromAsset("quotes.db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}