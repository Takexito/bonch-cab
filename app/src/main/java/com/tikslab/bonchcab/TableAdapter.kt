package com.tikslab.bonchcab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.Table
import com.tikslab.bonchcab.presenter.TablePresenter
import kotlinx.android.synthetic.main.table_item.view.*

class TableAdapter : RecyclerView.Adapter<TableAdapter.TableHolder>() {

    lateinit var context: Context

    inner class TableHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weekView = itemView.weekView
        val textView = itemView.dayTextView
    }

    override fun getItemCount(): Int {
        return TablePresenter.tables.lessons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableHolder {

        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.table_item, parent, false)
        return TableHolder(view)
    }

    override fun onBindViewHolder(holder: TableHolder, position: Int) {

        holder.weekView.adapter = ArrayAdapter<Lesson>(
            context, android.R.layout.simple_list_item_1,
            TablePresenter.tables.lessons[DayOfWeek.values()[position]]!!
        )
        holder.textView.text = DayOfWeek.values()[position].toString()
//        holder.weekView.layoutParams.height =
//            holder.weekView.count * holder.weekView.adapter.getView(0, null, holder.weekView).height
        holder.weekView.layoutParams.height = holder.weekView.count * 140
    }
}