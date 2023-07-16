package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    private val recylerview = findViewById<RecyclerView>(R.id.recyelerView)
    private val btnAdd = findViewById<Button>(R.id.btnAddTodo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        recylerview.adapter = todoAdapter
        recylerview.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener{
            val title = findViewById<TextView>(R.id.todoTile).text.toString()
            val toDo = Todo(title)
            todoAdapter.addToDoList(toDo)
            findViewById<TextView>(R.id.todoTile).text = ""
        }



    }
}