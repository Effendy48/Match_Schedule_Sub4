package com.example.lenovo.match_schedule.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lenovo.match_schedule.DetailMatchFavorite

import com.example.lenovo.match_schedule.R
import com.example.lenovo.match_schedule.adapter.FavoriteMatchAdapter
import com.example.lenovo.match_schedule.model.FavoriteMatch
import com.example.lenovo.match_schedule.db.database
import com.example.lenovo.match_schedule.model.Match
import com.example.lenovo.match_schedule.mvp.detail_match.MatchView
import com.example.lenovo.match_schedule.util.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FavoriteMatchFragment : Fragment(), AnkoComponent<Context>, MatchView {
    override fun showLoading() {
        listMatchFavorite.visible()

    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEventList(data: List<Match>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private lateinit var listMatchFavorite : RecyclerView
    private var favoriteMatch : MutableList<FavoriteMatch> = mutableListOf()
    private lateinit var FavoriteAdapter: FavoriteMatchAdapter
    private lateinit var swipeRefresh : SwipeRefreshLayout


    @SuppressLint("ResourceType")
    override fun createView(ui : AnkoContext<Context>) : View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                topPadding = dip(16)
                leftPadding = dip(16)
                rightPadding = dip(16)



                swipeRefresh = swipeRefreshLayout {
                    setColorSchemeResources(R.color.colorAccent,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)

                    listMatchFavorite = recyclerView {
                        id = R.id.list_match_favorite
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.create(ctx))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        FavoriteAdapter = FavoriteMatchAdapter(favoriteMatch){
            ctx.startActivity<DetailMatchFavorite>(DetailMatchFavorite.POSITION_EXTRA to it)
        }
        listMatchFavorite.adapter = FavoriteAdapter
        showFavorite()

        swipeRefresh.onRefresh {
            favoriteMatch.clear()
            showFavorite()
        }
    }

    private fun showFavorite(){
        context?.database?.use {
            swipeRefresh.isRefreshing = false
            val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
            val favoriteMatchs = result.parseList(classParser<FavoriteMatch>())
            favoriteMatch.addAll(favoriteMatchs)
            FavoriteAdapter.notifyDataSetChanged()
        }
    }
}
