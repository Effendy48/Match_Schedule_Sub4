package com.example.lenovo.match_schedule.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lenovo.match_schedule.R
import com.example.lenovo.match_schedule.model.FavoriteMatch

class FavoriteMatchAdapter(private var favoriteMatch: MutableList<FavoriteMatch>, var listener: (FavoriteMatch) -> Unit) : RecyclerView.Adapter<FavoriteMatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMatchViewHolder {
        return FavoriteMatchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_match_favorite, parent, false))

    }

    override fun getItemCount(): Int {
        return favoriteMatch.size

    }

    override fun onBindViewHolder(holder: FavoriteMatchViewHolder, position: Int) {
        holder.bindItem(favoriteMatch[position], listener)
    }
}

class FavoriteMatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val dateMatch: TextView = view.findViewById(R.id.tv_date_match_favorite)
    private val teamHomeScore: TextView = view.findViewById(R.id.home_team_score_favorite)
    private val teamAwayScore: TextView = view.findViewById(R.id.away_team_score_favorite)
    private val teamHomeName: TextView = view.findViewById(R.id.home_team_favorite)
    private val teamAwayName: TextView = view.findViewById(R.id.away_team_favorite)

    fun bindItem(favoriteMatch: FavoriteMatch, listener: (FavoriteMatch) -> Unit) {

        dateMatch.text = favoriteMatch.dateEvent
        teamHomeScore.text = favoriteMatch.scoreTeamHome
        teamAwayScore.text = favoriteMatch.scoreTeamAway
        teamHomeName.text = favoriteMatch.teamHomeName
        teamAwayName.text = favoriteMatch.teamAwayName


        if (favoriteMatch.scoreTeamHome == "null") teamHomeScore.text = "-"
        else teamHomeScore.text = favoriteMatch.scoreTeamHome
        if (favoriteMatch.scoreTeamAway == "null") teamAwayScore.text = "-"
        else teamAwayScore.text = favoriteMatch.scoreTeamAway

        itemView.setOnClickListener {
            listener(favoriteMatch)
        }
    }
}
