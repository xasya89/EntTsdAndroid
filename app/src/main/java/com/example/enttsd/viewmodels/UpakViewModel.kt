package com.example.enttsd.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enttsd.models.NaryadModel
import okhttp3.OkHttpClient
import okhttp3.internal.notify
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class UpakViewModel:ViewModel() {
    val naryadList= MutableLiveData<ArrayList<NaryadModel>>()

    val naryadSearch = MutableLiveData<String>()
    val naryadSearchedList = MutableLiveData<ArrayList<NaryadModel>>()
    private val api:EntApi

    init {
        naryadList.value= ArrayList()

        val loggin = HttpLoggingInterceptor()
        loggin.level=HttpLoggingInterceptor.Level.BODY

        val okHttpClient=OkHttpClient.Builder().addInterceptor(loggin).build()

        var retrofit=Retrofit.Builder()
            .baseUrl("http://172.172.172.45:5219")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(EntApi::class.java)
    }

    fun search(find:String){
        val request: Call<ArrayList<NaryadModel>> = api.getNaryad(find)
        request.enqueue(object : Callback<ArrayList<NaryadModel>>{
            override fun onResponse(
                call: Call<ArrayList<NaryadModel>>,
                response: Response<ArrayList<NaryadModel>>
            ) {
                naryadSearchedList.value=response.body()
            }

            override fun onFailure(call: Call<ArrayList<NaryadModel>>, t: Throwable) {
                Log.d("response error",t.message.toString())
            }
        })
    }

    fun addSearchNaryad(naryad: NaryadModel){
        var flagFind:Boolean = false
        for(n in naryadList?.value!!)
            if(naryad.naryadId==n.naryadId)
                flagFind=true
        if(!flagFind){
            naryadList.value?.add(naryad)
            naryadList.value=naryadList.value
        }
    }

    fun deleteSearchNaryad(naryad: NaryadModel){
        for(i in 0..naryadList.value?.size!! - 1)
            if(naryad.naryadId==naryadList.value?.get(i)!!.naryadId){
                naryadList.value?.removeAt(i)
            }
        naryadList.value=naryadList.value
    }
}