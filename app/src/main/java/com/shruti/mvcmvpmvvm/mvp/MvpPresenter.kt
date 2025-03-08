package com.shruti.mvcmvpmvvm.mvp

class MvpPresenter(private val mvpModel: MvpModel, private val view:View) {

    interface View{
        fun updateTextView(data:String)
    }

    public fun updateLoginData(name:String,email:String){
        mvpModel.setName(name)
        mvpModel.setEmail(email)
        view.updateTextView(mvpModel.toString())
    }



}