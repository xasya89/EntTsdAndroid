package com.example.enttsd.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enttsd.models.LoginModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class EntRestViewModel:ViewModel() {
    private val api:EntApi
    public val loginModel = MutableLiveData<LoginModel>()

    init {
        val loging= HttpLoggingInterceptor()
        loging.level= HttpLoggingInterceptor.Level.BODY

        val okhttpClient = OkHttpClient.Builder().addInterceptor(loging).build()

        var retrofit = Retrofit.Builder()
            .baseUrl("http://172.172.172.45:5219")
            .client(okhttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
        api = retrofit.create(EntApi::class.java)
    }


    fun getLogin(cardNumber:String) {
        val responseLiveData: MutableLiveData<LoginModel> = MutableLiveData()

        val request: Call<LoginModel> = api.getLogin(LoginModel(0,0,"","",cardNumber))
        request.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                /*
                if(response.code()==401){
                    var requestJwt: Call<JwtModel> = api.getJWT()
                    requestJwt.enqueue(object : Callback<JwtModel> {
                        override fun onResponse(call: Call<JwtModel>, response: Response<JwtModel>) {
                            token = response.body()?.token.toString()
                            getLogin()
                        }

                        override fun onFailure(call: Call<JwtModel>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                    })
                }
                Log.d("TAG","bodt- ${response.code()}")
                 */
                loginModel.value = response.body()
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Log.d("TAG", "Failed fetch",t)
            }

        })
    }
}