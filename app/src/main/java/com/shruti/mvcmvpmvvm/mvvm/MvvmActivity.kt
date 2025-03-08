package com.shruti.mvcmvpmvvm.mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shruti.mvcmvpmvvm.R

class MvvmActivity : AppCompatActivity() {

    private lateinit var btnAddQuote:Button
    private lateinit var tvQuotesList:TextView
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mvvm)


        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init(){
        btnAddQuote = findViewById(R.id.btnAddQuote)
        tvQuotesList = findViewById(R.id.tvQuotesList)


        val roomDatabase = QuoteDatabase.getDatabase(this)
        val quoteDao = roomDatabase.quoteDao()
        val repository = QuotesRepository(quoteDao)

        myViewModel = ViewModelProvider(this,MyViewModelFactory(repository)).get(MyViewModel::class.java)
        myViewModel.getQuotes().observe(this) {
            var s = ""
            for (i in it){
                s +=  i.id.toString()+" "+i.author + " "+i.text+" "
            }
           tvQuotesList.text  = s
            Log.d("TAG", "init: "+it.listIterator())
        }

        btnAddQuote.setOnClickListener{
            myViewModel.insertQuotes(QuoteModel(0,"Keep LEarning","ShruJay"))
        }

    }
}