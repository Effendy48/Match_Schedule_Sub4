package com.example.lenovo.match_schedule.mvp.detail_match

import com.example.lenovo.match_schedule.TestContextProvider
import com.example.lenovo.match_schedule.api.ApiInterface
import com.example.lenovo.match_schedule.api.ApiRepository
import com.example.lenovo.match_schedule.api.TheSportDbApi
import com.example.lenovo.match_schedule.model.DetailTeam
import com.example.lenovo.match_schedule.model.DetailTeamResponse
import com.example.lenovo.match_schedule.util.CoroutineContextProvider
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class DetailMatchPresenterTest {
    @Mock
    private
    lateinit var view: DetailMatchView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var presenter: DetailMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailMatchPresenter(view, apiRepository, gson, TestContextProvider())
    }

    //Untuk mengetest response URL data Gambar berdasarkan id Team
    @Test
    fun testGetAwayTeamDetail(){
        val data : MutableList<DetailTeam> = mutableListOf()
        val response = DetailTeamResponse(data)
        val id = "1234"
        `when`(gson.fromJson(apiRepository.doRequest(TheSportDbApi.getIdTeamAway(id)), DetailTeamResponse::class.java))
                .thenReturn(response)
        presenter.getTeamAway(id)

        verify(view).showLoading()
        verify(view).showImageAwayTeam(response.teams!!)
    }

    @Test
    fun testGetHomeTeamDetail(){
        val data : MutableList<DetailTeam> = mutableListOf()
        val response = DetailTeamResponse(data)
        val id = "1234"
        `when`(gson.fromJson(apiRepository.doRequest(TheSportDbApi.getIdTeamHome(id)), DetailTeamResponse::class.java))
                .thenReturn(response)
        presenter.getTeamHome(id)

        verify(view).showLoading()
        verify(view).showImageHomeTeam(response.teams!!)

    }
}