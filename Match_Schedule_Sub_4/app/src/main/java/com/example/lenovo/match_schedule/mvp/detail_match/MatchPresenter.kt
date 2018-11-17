package com.example.lenovo.match_schedule.mvp.detail_match

import com.example.lenovo.match_schedule.api.ApiInterface
import com.example.lenovo.match_schedule.api.ApiRepository
import com.example.lenovo.match_schedule.api.TheSportDbApi
import com.example.lenovo.match_schedule.model.Match
import com.example.lenovo.match_schedule.model.MatchResponse
import com.example.lenovo.match_schedule.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.custom.async
import retrofit2.Call
import retrofit2.Response

class MatchPresenter (private val view : MatchView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson,
                      private val context : CoroutineContextProvider = CoroutineContextProvider()){
    fun getPastMatch(id : String){
        view.showLoading()
        async(context.main){
            val dataPastMatch = bg{
                gson.fromJson(apiRepository.doRequest(TheSportDbApi.getPastMatch(id)),MatchResponse::class.java)

            }
            view.showEventList(dataPastMatch.await().matchs)
            view.hideLoading()
        }

    }
    fun getNextMatch(id : String){
        view.showLoading()
        async(context.main){
            val dataNextMatch = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDbApi.getNextMatch(id)), MatchResponse::class.java)
            }
            view.showEventList(dataNextMatch.await().matchs)
            view.hideLoading()
        }
    }
}