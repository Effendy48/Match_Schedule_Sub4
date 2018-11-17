package com.example.lenovo.match_schedule.fragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.example.lenovo.match_schedule.DetailMatch
import com.example.lenovo.match_schedule.R
import com.example.lenovo.match_schedule.adapter.MatchAdapter
import com.example.lenovo.match_schedule.api.ApiRepository
import com.example.lenovo.match_schedule.model.Match
import com.example.lenovo.match_schedule.mvp.detail_match.MatchPresenter
import com.example.lenovo.match_schedule.mvp.detail_match.MatchView
import com.example.lenovo.match_schedule.util.invisible
import com.example.lenovo.match_schedule.util.visible
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.*

class PastMatchFragment : Fragment(),AnkoLogger,MatchView {


    private val matchs : MutableList<Match> = mutableListOf()
    private lateinit var mAdapter : MatchAdapter
    private lateinit var progressBar: ProgressBar
    private var id = "4328"
    private lateinit var presenter: MatchPresenter
    private lateinit var recyclerView: RecyclerView

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        presenter = MatchPresenter(this, ApiRepository(), Gson())
        recyclerView = find(R.id.list_past_match)
        mAdapter = MatchAdapter(matchs) {
                startActivity<DetailMatch>(DetailMatch.POSITION_EXTRA to it)
        }
        recyclerView.layoutManager = LinearLayoutManager(ctx)
        recyclerView.adapter = mAdapter

        presenter.getPastMatch(id)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View = with(container) {


        return UI {
           linearLayout {
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL

                swipeRefreshLayout {
                    onRefresh {
                        Handler().postDelayed({
                            setColorSchemeColors(
                                    resources.getColor(R.color.colorPrimary),
                                    resources.getColor(R.color.colorPrimaryDark),
                                    resources.getColor(R.color.colorAccent)
                            )
          //                  setupEnv()
                            isRefreshing = false
                        }, 3000)
                    }
                    recyclerView {
                        lparams(matchParent, matchParent)
                        id = R.id.list_past_match
                        //layoutManager = LinearLayoutManager(ctx)
                        //adapter = mAdapter
                    }
                }
            }
        }.view

    }

    private fun showEventListData(data : List<Match>){
       matchs.clear()
        matchs.addAll(data)
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
      //  progressBar.visible()
        recyclerView.invisible()
    }

    override fun hideLoading() {
        //progressBar.invisible()
        recyclerView.visible()
    }

    override fun showEmptyData() {
        //progressBar.invisible()
        recyclerView.invisible()
    }

    override fun showEventList(data: List<Match>) {
        showEventListData(data)
    }
}
