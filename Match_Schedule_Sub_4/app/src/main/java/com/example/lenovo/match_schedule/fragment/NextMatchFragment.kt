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

class NextMatchFragment : Fragment(), AnkoLogger, MatchView {
    override fun showEmptyData() {

    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        }

    override fun showEventList(data: List<Match>) {
        nextMatch.clear()
        nextMatch.addAll(data)
        MAdapter.notifyDataSetChanged()
    }

    private val nextMatch: MutableList<Match> = mutableListOf()
    private lateinit var MAdapter: MatchAdapter
    private lateinit var rv_next_match: RecyclerView
    private var id = "4328"
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter : MatchPresenter


    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        presenter = MatchPresenter(this, ApiRepository(), Gson())
        rv_next_match = find(R.id.list_next_match)

        MAdapter = MatchAdapter(nextMatch) {
            startActivity<DetailMatch>(DetailMatch.POSITION_EXTRA to it)
        }

        rv_next_match.adapter = MAdapter
        rv_next_match.layoutManager = LinearLayoutManager(context)
        presenter.getNextMatch(id)
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
                            //loadData()
                            isRefreshing = false
                        }, 3000)
                    }
                    relativeLayout {
                        lparams(width = matchParent, height = wrapContent)

                    recyclerView {
                        lparams(matchParent, matchParent)
                        id = R.id.list_next_match
                    }
                        progressBar = progressBar {

                        }.lparams{
                            centerHorizontally()
                        }
                }
                }
            }
        }.view
    }
}

