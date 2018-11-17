package com.example.lenovo.match_schedule.mvp.detail_match

import com.example.lenovo.match_schedule.api.ApiInterface
import com.example.lenovo.match_schedule.api.ApiRepository
import com.example.lenovo.match_schedule.api.TheSportDbApi
import com.example.lenovo.match_schedule.model.DetailTeam
import com.example.lenovo.match_schedule.model.DetailTeamResponse
import com.example.lenovo.match_schedule.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Response

class DetailMatchPresenter(private val view : DetailMatchView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson,
                           private val context : CoroutineContextProvider = CoroutineContextProvider()
                           ) {
    fun getTeamHome(id : String){
        view.showLoading()
        async(context.main){
            val dataHomeTeam = bg{
                gson.fromJson(apiRepository.
                        doRequest(TheSportDbApi.getIdTeamHome(id.toString())),
                        DetailTeamResponse::class.java
                        )
            }

            view.showImageHomeTeam(dataHomeTeam.await().teams!!)
            view.hideLoading()

        }
    }
    fun getTeamAway(id : String){
        view.showLoading()
        async(context.main){
            val dataAwayTeam = bg{
                gson.fromJson(apiRepository.doRequest(TheSportDbApi.getIdTeamAway(id.toString())), DetailTeamResponse::class.java)
            }

            view.showImageAwayTeam(dataAwayTeam.await().teams)
            view.hideLoading()
        }
    }
}