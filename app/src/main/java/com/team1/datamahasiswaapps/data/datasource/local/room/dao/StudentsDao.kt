package com.team1.datamahasiswaapps.data.datasource.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.team1.datamahasiswaapps.data.datasource.local.room.entity.StudentsDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudentData(data: StudentsDataEntity)

    @Query("SELECT * FROM StudentsDataEntity ORDER BY username ASC ")
     fun getAllData(): Flow<List<StudentsDataEntity>>

    @Query("UPDATE studentsdataentity SET username = :newUsername, address = :newAddress WHERE id = :id")
    suspend fun updateDataStudent(newUsername:String,newAddress:String,id: Int)

    @Delete
    suspend fun deleteDataStudent(data: StudentsDataEntity)

    @Query("SELECT * FROM Studentsdataentity where id = :id")
    fun getDetailStudentData(id: Int): Flow<StudentsDataEntity>
}