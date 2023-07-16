package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        todoAdapter = TodoAdapter(mutableListOf())

        recyelerView.adapter = todoAdapter
        recyelerView.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            val title = findViewById<TextView>(R.id.enterToDoTitle).text.toString()
            val toDo = Todo(title)
            todoAdapter.addToDoList(toDo)
            findViewById<TextView>(R.id.enterToDoTitle).text = ""
        }

        btnDeleteTodo.setOnClickListener {
            todoAdapter.removeFromToDoList()
        }







    }
}