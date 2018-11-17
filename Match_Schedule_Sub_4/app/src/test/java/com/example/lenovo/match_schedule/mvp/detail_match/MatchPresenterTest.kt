package com.example.lenovo.match_schedule.mvp.detail_match

import com.example.lenovo.match_schedule.TestContextProvider
import com.example.lenovo.match_schedule.api.ApiInterface
import com.example.lenovo.match_schedule.api.ApiRepository
import com.example.lenovo.match_schedule.api.TheSportDbApi
import com.example.lenovo.match_schedule.model.Match
import com.example.lenovo.match_schedule.model.MatchResponse
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Response

class MatchPresenterTest {
    @Mock
    private lateinit var Api: ApiRepository
    @Mock
    private lateinit var presenter: MatchPresenter
    @Mock
    private lateinit var gson: Gson
    @Mock
    private lateinit var view: MatchView


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = MatchPresenter(view, Api, gson, TestContextProvider())
    }
    //Request URL Match.
    //NextMatch and PastMatch
    @Test
    fun getPastMatch() {
        val dataMatch : MutableList<Match> = mutableListOf()
        val response = MatchResponse(dataMatch)
        val id = "1234"
        `when`(gson.fromJson(Api.doRequest(TheSportDbApi.getPastMatch(id)), MatchResponse::class.java))
                .thenReturn(response)
        presenter.getPastMatch(id)

        verify(view).showLoading()
        verify(view).showEventList(response.matchs)
    }
    @Test
    fun getNextMatch(){
        val dataMatch : MutableList<Match> = mutableListOf()
        val response = MatchResponse(dataMatch)
        val id = "1234"
        `when`(gson.fromJson(Api.doRequest(TheSportDbApi.getNextMatch(id)), MatchResponse::class.java))
                .thenReturn(response)
        presenter.getNextMatch(id)

        verify(view).showLoading()
        verify(view).showEventList(response.matchs)

    }
}