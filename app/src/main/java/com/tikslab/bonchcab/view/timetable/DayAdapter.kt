package com.tikslab.bonchcab.view.timetable

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tikslab.bonchcab.R
import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.presenter.TablePresenter
import kotlinx.android.synthetic.main.week_item.view.*


class DayAdapter(day: DayOfWeek) : RecyclerView.Adapter<DayAdapter.DayHolder>() {

    private lateinit var context: Context
    private val data = TablePresenter.weekTable.days[day]!!

    class DayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lessonText: TextView = itemView.lessonText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.week_item, parent, false)
        return DayHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        holder.lessonText.text = data[position].toString()
    }
}