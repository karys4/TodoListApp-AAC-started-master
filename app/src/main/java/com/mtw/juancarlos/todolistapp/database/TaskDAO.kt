package com.mtw.juancarlos.todolistapp.database

import android.arch.persistence.room.*

@Dao
interface TaskDAO {
    //Métodos para acceso a datos

    @Query  ("SELECT * FROM task ORDER BY priority")
    fun loadAltTask() : List<TaskEntry>

    @Insert
    fun insertTask (taskEntry: TaskEntry)

    @Update (onConflict = OnConflictStrategy.REPLACE)
    fun updateTask (taskEntry: TaskEntry)

    @Delete
    fun deleteTask (taskEntry: TaskEntry)

    @Query ("DELETE FROM task")
    fun deleteAll()

    @Query("SELECT * FROM task WHERE id = :id")
    fun loadTaskById(id:Long):TaskEntry




}