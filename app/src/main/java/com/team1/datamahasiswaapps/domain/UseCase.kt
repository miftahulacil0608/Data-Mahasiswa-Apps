package com.team1.datamahasiswaapps.domain

import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.data.datasource.local.LocalCRUDImpl
import com.team1.datamahasiswaapps.domain.model.Students
import com.team1.datamahasiswaapps.domain.repository.CRUDRepository
import kotlinx.coroutines.flow.Flow

class UseCase(val crudRepository: CRUDRepository) {
    suspend fun getAllStudentsData(): Flow<ResourcesState<List<Students>>>{
        return crudRepository.getAllStudentsData()
    }
    suspend fun addStudentsData(dataInput:Students){
        crudRepository.addStudentData(dataInput)
    }
    suspend fun updateStudentsData(newUsername:String,newAddress:String,id: Int){
        crudRepository.updatedStudentData(newUsername,newAddress,id)
    }
    suspend fun deleteStudentsData(dataInput: Students){
        crudRepository.deletedStudentData(dataInput)
    }
    suspend fun getDetailStudentsData(id:Int):Flow<ResourcesState<Students>>{
        return crudRepository.getDetailStudentData(id)
    }
}