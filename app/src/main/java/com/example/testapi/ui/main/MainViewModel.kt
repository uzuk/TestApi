package com.example.testapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapi.network.Api
import com.example.testapi.network.BASE_URL
import com.example.testapi.network.QUERY_S
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    ////response
    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    init {
        getItData()
    }
    /////request for data from APi
    private fun getItData() {
        Api.retrofitService.getIt().enqueue( object: Callback<String> {
            ////////////on failure
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message + "\n\n" + "BASE : " + BASE_URL + "\n\nQuery Get:\n" + QUERY_S
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = "Success: " + response.body().toString() + "\n\n" + "BASE :  " + BASE_URL + "\n\nQuery Get:\n" + QUERY_S
            }
        })

    }

}