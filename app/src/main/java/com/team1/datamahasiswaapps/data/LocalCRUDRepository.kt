package com.team1.datamahasiswaapps.data

import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.domain.model.Students
import kotlinx.coroutines.flow.Flow

interface LocalCRUDRepository {
    suspend fun localGetAllStudentsData(): Flow<ResourcesState<List<Students>>>
    suspend fun localAddStudentData(dataInput: Students)
    suspend fun localUpdatedStudentData(newUsername:String,newAddress:String,id: Int)
    suspend fun localDeletedStudentData(dataInput: Students)
    suspend fun localGetDetailStudentData(id: Int): Flow<ResourcesState<Students>>
}