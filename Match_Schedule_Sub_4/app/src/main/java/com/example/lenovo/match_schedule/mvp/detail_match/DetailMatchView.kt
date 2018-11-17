package com.example.lenovo.match_schedule.mvp.detail_match

import com.example.lenovo.match_schedule.model.DetailTeam

interface DetailMatchView {
    fun showLoading()
    fun hideLoading()
    fun showImageHomeTeam(data : List<DetailTeam>)
    fun showImageAwayTeam(data : List<DetailTeam>)
}