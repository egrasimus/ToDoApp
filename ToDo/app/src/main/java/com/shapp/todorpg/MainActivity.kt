package com.shapp.todorpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.shapp.todorpg.room.AppDatabase
import com.shapp.todorpg.room.Note

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            for (i in 1..5) {
                supportFragmentManager.beginTransaction()
                        .add(R.id.main_container2, SomeFragment.newInstance("$i Tasks Available", "$i Tasks"))
                        .commit()
            }
        }
        
        val list = findViewById<RecyclerView>(R.id.recyclerView2)
        val tasks = generateTasks()
        val adapter = TasksAdapter(this,tasks)
        list.adapter = adapter

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        val noteDao = db.noteDao()
        val notes: List<Note> = noteDao.getAll()
    }



    fun generateTasks(): List<Task>{
        return listOf(
            Task("День Рождения Кирилла", "13 мая", true),
            Task("Убраться на кухне", "15 мая", false),
            Task("Сходить в продуктовый", "26 мая", false),
            Task("День Рождения города", "17 мая", true)
        )
    }
}