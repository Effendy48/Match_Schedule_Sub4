package com.example.lenovo.match_schedule.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class FavoriteMatch (val Id : Long? ,
                          val idEvent : String?,
                          val teamHomeId : String?,
                          val teamAwayId : String?,

                          val teamHomeName : String?,
                          val teamAwayName : String?,

                          val teamHomeGoals : String?,
                          val teamAwayGoals : String?,

                          val teamHomeGK : String?,
                          val teamAwayGK : String?,
                          val teamHomeDefence : String?,
                          val teamAwayDefence : String?,
                          val teamHomeMidfield : String?,
                          val teamAwayMidfield : String?,
                          val teamHomeForward : String?,
                          val teamAwayForward : String?,
                          val teamHomeSubtitutes : String?,
                          val teamAwaySubtitutes : String?,

                          val imageTeamHome : String?,
                          val imageTeamAway : String?,
                          val scoreTeamHome : String?,
                          val scoreTeamAway: String?,
                          val dateEvent : String?) : Parcelable{
    companion object {
        const val TABLE_FAVORITE_MATCH : String = "TABLE_FAVORITE_MATCH"
        const val ID : String = "ID_"
        const val ID_EVENT : String = "ID_EVENT"
        const val TEAM_HOME_ID : String = "TEAM_HOME_ID"
        const val TEAM_AWAY_ID : String = "TEAM_AWAY_ID"

        const val TEAM_HOME_NAME : String = "TEAM_HOME_NAME"
        const val TEAM_AWAY_NAME : String = "TEAM_AWAY_NAME"

        const val TEAM_HOME_GOALS : String = "TEAM_HOME_GOALS"
        const val TEAM_AWAY_GOALS : String = "TEAM_AWAY_GOALS"

        const val TEAM_HOME_GK : String = "TEAM_HOME_GK"
        const val TEAM_AWAY_GK : String = "TEAM_AWAY_GK"
        const val TEAM_HOME_DEFENCE : String = "TEAM_HOME_DEFENCE"
        const val TEAM_AWAY_DEFENCE : String = "TEAM_AWAY_DEFENCE"
        const val TEAM_HOME_MIDFIELD : String = "TEAM_HOME_MIDFIELD"
        const val TEAM_AWAY_MIDFIELD : String = "TEAM_AWAY_MIDFIELD"
        const val TEAM_HOME_FORWARD : String = "TEAM_HOME_FORWARD"
        const val TEAM_AWAY_FORWARD : String = "TEAM_AWAY_FORWARD"
        const val TEAM_HOME_SUBTITUTES : String = "TEAM_HOME_SUBTITUTES"
        const val TEAM_AWAY_SUBTITUTES : String = "TEAM_AWAY_SUBTITUTES"

        const val TEAM_HOME_IMAGE : String = "TEAM_HOME_IMAGE"
        const val TEAM_AWAY_IMAGE : String = "TEAM_AWAY_IMAGE"
        const val TEAM_HOME_SCORE : String = "TEAM_HOME_SCORE"
        const val TEAM_AWAY_SCORE : String = "TEAM_AWAY_SCORE"
        const val DATE_EVENT : String = "DATE_EVENT"

    }
}