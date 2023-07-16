package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (private val list:MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        )
    }

    private fun strikeTrough(title: TextView, checkbox: Boolean){
        if (checkbox){
            title.paintFlags = title.paintFlags or STRIKE_THRU_TEXT_FLAG;
        }else{
            title.paintFlags = title.paintFlags and STRIKE_THRU_TEXT_FLAG.inv();
        }
    }

    fun addToDoList(todo: Todo){
        list.add(todo);
        notifyItemInserted(list.size - 1)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val current = list[position]
        holder.itemView.findViewById<TextView>(R.id.todoTile).setText(current.title);
//        holder.itemView.findViewById<CheckBox>(R.id.todoDone)

    }


    override fun getItemCount(): Int {
        return list.size
    }
}