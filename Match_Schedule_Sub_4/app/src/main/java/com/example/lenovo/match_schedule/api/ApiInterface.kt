package com.example.lenovo.match_schedule.api

import android.telecom.Call
import com.example.lenovo.match_schedule.BuildConfig
import com.example.lenovo.match_schedule.model.DetailTeam
import com.example.lenovo.match_schedule.model.DetailTeamResponse
import com.example.lenovo.match_schedule.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Query


 interface ApiInterface {
    @GET("api/v1/json/${BuildConfig.TSDB_API_KEY}/eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String): retrofit2.Call<MatchResponse>

    @GET("api/v1/json/${BuildConfig.TSDB_API_KEY}/eventspastleague.php")
    fun getPastMatch(@Query("id") id: String): retrofit2.Call<MatchResponse>

    @GET("api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupteam.php/preview")
    fun getIdTeamHome(@Query("id") id: String): retrofit2.Call<DetailTeamResponse>

    @GET("api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupteam.php/preview")
    fun getIdTeamAway(@Query("id") id: String): retrofit2.Call<DetailTeamResponse>


 }