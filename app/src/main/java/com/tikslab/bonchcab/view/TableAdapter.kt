package com.tikslab.bonchcab.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tikslab.bonchcab.R
import com.tikslab.bonchcab.model.Util
import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.presenter.TablePresenter
import kotlinx.android.synthetic.main.table_item.view.*

class TableAdapter : RecyclerView.Adapter<TableAdapter.TableHolder>() {

    private lateinit var context: Context

    inner class TableHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weekView: RecyclerView = itemView.weekView
        val textView: TextView = itemView.dayTextView
    }

    override fun getItemCount(): Int {
        return TablePresenter.weekTable.days.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.table_item, parent, false)
        return TableHolder(view)
    }

    override fun onBindViewHolder(holder: TableHolder, position: Int) {

        holder.itemView.setBackgroundResource(R.color.colorPrimary)

        val day = DayOfWeek.values()[position]

        val days = TablePresenter.weekTable.days
        if (days[day]!!.isEmpty()) days[day]!!.add(Util.getNoLessons())

        if (day == TablePresenter.getCurrDayOfWeek())
            holder.itemView.setBackgroundResource(R.color.colorPrimaryDark)

        holder.weekView.layoutManager = LinearLayoutManager(context)
        holder.weekView.adapter = DayAdapter(day)
        holder.textView.text = day.toString()

    }

}