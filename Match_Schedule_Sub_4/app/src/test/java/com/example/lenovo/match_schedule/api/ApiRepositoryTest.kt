package com.example.lenovo.match_schedule.api

import com.example.lenovo.match_schedule.BuildConfig
import com.example.lenovo.match_schedule.model.DetailTeam
import com.example.lenovo.match_schedule.model.DetailTeamResponse
import com.example.lenovo.match_schedule.model.MatchResponse
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Mock
private lateinit var apiRepository: ApiInterface
@Mock
private lateinit var gson : Gson


class ApiRepositoryTest{
    @Test
    fun doRequest() {
        val apiRepository = Mockito.mock(ApiRepository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/4012900/eventspastleague.php?id=4328"
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }
}


