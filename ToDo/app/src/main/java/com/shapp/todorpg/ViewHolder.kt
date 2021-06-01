package com.shapp.todorpg

import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val task: TextView = itemView.findViewById(R.id.task)
    private val deadline: TextView = itemView.findViewById(R.id.deadline)
    private val isDone: RadioButton = itemView.findViewById(R.id.isDone)

    fun bind(item: Task){
        task.text = item.task
        deadline.text = item.deadline
        isDone.isChecked = item.isDone
    }

}