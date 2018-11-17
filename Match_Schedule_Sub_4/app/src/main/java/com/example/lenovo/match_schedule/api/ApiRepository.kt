package com.example.lenovo.match_schedule.api

import com.example.lenovo.match_schedule.BuildConfig
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class ApiRepository{
    fun doRequest(url : String) = URL(url).readText()

}