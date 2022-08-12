package com.example.enttsd.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enttsd.models.LoginModel

class LoginRepository:ViewModel() {
    public val loginModel = MutableLiveData<LoginModel>()
}