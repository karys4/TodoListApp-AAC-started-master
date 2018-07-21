package com.mtw.juancarlos.todolistapp.database

import android.arch.persistence.room.TypeConverter
import java.sql.Timestamp
import java.util.*

class DateConverter {
    @TypeConverter
    fun toDate(timeStamp: Long?): Date? {
        return if (timeStamp != null) Date(timeStamp) else null
    }

    @TypeConverter
    fun toTimeStamp(date:Date?) : Long? = date?.time

}