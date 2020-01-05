package com.tikslab.bonchcab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.Table
import com.tikslab.bonchcab.presenter.TablePresenter
import kotlinx.android.synthetic.main.table_item.view.*

class TableAdapter : RecyclerView.Adapter<TableAdapter.TableHolder>() {

    lateinit var context: Context

    inner class TableHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weekView = itemView.weekView
    }

    override fun getItemCount(): Int {
        return TablePresenter.tables.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableHolder {

        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.table_item, parent, false)
        return TableHolder(view)
    }

    override fun onBindViewHolder(holder: TableHolder, position: Int) {

        holder.weekView.adapter = ArrayAdapter<Table>(
            context, R.layout.week_item,
            TablePresenter.tables
        )
        holder.itemView.weekView.adapter = ArrayAdapter<Lesson>(
            context, R.layout.lesson_item,
            R.id.textView,
            TablePresenter.getLessons(position)

        )
    }
}