package com.team1.datamahasiswaapps.data.datasource.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.team1.datamahasiswaapps.data.datasource.local.room.dao.StudentsDao
import com.team1.datamahasiswaapps.data.datasource.local.room.entity.StudentsDataEntity

@Database(entities = [StudentsDataEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun studentsDao(): StudentsDao
}