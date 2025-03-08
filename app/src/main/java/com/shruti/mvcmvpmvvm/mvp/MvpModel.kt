package com.shruti.mvcmvpmvvm.mvp

class MvpModel {

    private var name:String = ""
    private var email:String = ""

    fun setName(name:String){
        this.name = name
    }

    fun setEmail(email:String){
        this.email = email
    }

    fun getName():String{
        return name
    }

    fun getEmail():String{
        return email
    }

    override fun toString():String{
        return name+"\n"+ email
    }

}