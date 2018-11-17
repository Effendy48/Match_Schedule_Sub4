package com.example.lenovo.match_schedule.api

import com.example.lenovo.match_schedule.BuildConfig
import com.example.lenovo.match_schedule.model.DetailTeamResponse
import com.example.lenovo.match_schedule.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Query

object TheSportDbApi{

    fun getNextMatch(id: String): String{
       return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/eventsnextleague.php?id=${id}"
    }

    fun getPastMatch(id: String): String {
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/eventspastleague.php?id=${id}"
    }

   fun getIdTeamHome(id: String) : String{
      return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupteam.php/preview?id=${id}"

   }

    fun getIdTeamAway(id: String): String {
        return  "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupteam.php/preview?id=${id}"
    }

}