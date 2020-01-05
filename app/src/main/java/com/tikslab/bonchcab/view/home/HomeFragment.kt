package com.tikslab.bonchcab.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tikslab.bonchcab.R
import com.tikslab.bonchcab.TableAdapter
import com.tikslab.bonchcab.presenter.TablePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(this, Observer {
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prevButton.setOnClickListener {
            homeViewModel.prevWeek()
        }

        nextButton.setOnClickListener {
            homeViewModel.nextWeek()
        }

        val tableAdapter = TableAdapter()
        TablePresenter.adapter = tableAdapter
        val manager = LinearLayoutManager(this.context)

        tableView.apply {
            adapter = tableAdapter
            layoutManager = manager
        }

        tableView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            var isScrolling = false

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (manager.findFirstVisibleItemPosition() <= 1 && isScrolling && dy < 0) {
                    TablePresenter.scrollLoad(false)
                    Log.d("Recycler onScrolled", "Event prev. Week")
                }

                if (manager.findLastVisibleItemPosition() >= tableAdapter.itemCount - 1 && isScrolling && dy > 0) {
                    TablePresenter.scrollLoad(true)
                    Log.d("Recycler onScrolled", "Event next. Week")

                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                isScrolling = newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL
            }

        })
    }
}