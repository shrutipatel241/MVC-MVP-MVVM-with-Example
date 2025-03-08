package com.shruti.mvcmvpmvvm.mvp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shruti.mvcmvpmvvm.R

class MvpActivity : AppCompatActivity(), MvpPresenter.View{

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvUpdateData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mvp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init(){
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        btnLogin = findViewById(R.id.btnLogin)
        tvUpdateData = findViewById(R.id.tvUpdateData)

        btnLogin.setOnClickListener{
            onLoginButtonClicked(etName.text.toString(),etEmail.text.toString())
        }
    }

    private fun onLoginButtonClicked(name: String, email: String) {
        val mvpModel = MvpModel()
        val mvpPresenter = MvpPresenter(mvpModel,this)
        mvpPresenter.updateLoginData(name,email)
    }

    override fun updateTextView(data: String) {
        tvUpdateData.text = data
    }
}