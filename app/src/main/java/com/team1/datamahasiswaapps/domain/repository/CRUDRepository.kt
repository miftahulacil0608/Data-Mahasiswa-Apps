package com.team1.datamahasiswaapps.domain.repository

import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.domain.model.Students
import kotlinx.coroutines.flow.Flow

interface CRUDRepository {
    suspend fun getAllStudentsData(): Flow<ResourcesState<List<Students>>>
    suspend fun addStudentData(dataInput: Students)
    suspend fun updatedStudentData(newUsername:String,newAddress:String,id: Int)
    suspend fun deletedStudentData(dataInput: Students)
    suspend fun getDetailStudentData(id: Int): Flow<ResourcesState<Students>>
}