package com.example.lenovo.match_schedule.mvp.detail_match

import com.example.lenovo.match_schedule.model.Match

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showEmptyData()
    fun showEventList(data : List<Match>)
}