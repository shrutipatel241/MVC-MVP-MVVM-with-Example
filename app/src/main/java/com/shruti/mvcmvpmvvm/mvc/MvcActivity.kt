package com.shruti.mvcmvpmvvm.mvc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shruti.mvcmvpmvvm.R

class MvcActivity : AppCompatActivity() {

    private lateinit var etName:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mvc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
    }

    private fun init(){
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassowrd)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            onLoginButtonClicked(etName.text.toString(),etPassword.text.toString())
        }
    }

    private fun onLoginButtonClicked(etName: String, etPassword: String) {
        val loginModel = LoginModel()
        if(loginModel.name == etName && loginModel.password == etPassword){
            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Login failed$etName $etPassword", Toast.LENGTH_SHORT).show()
        }
    }
}