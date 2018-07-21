package com.mtw.juancarlos.todolistapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database (entities = arrayOf(TaskEntry::class),version = 1,exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase () {

    companion object {
        private var Instance : AppDatabase? = null

        fun getIntance(context: Context) : AppDatabase? {
            if (Instance == null) {

        synchronized(AppDatabase:: class) {
            Instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "todoList.db"

            ).allowMainThreadQueries()
                    .build()
        }
        }
            return Instance


        }
    }

    abstract fun taskDao() : TaskDAO

}