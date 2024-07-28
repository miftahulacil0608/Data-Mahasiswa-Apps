package com.team1.datamahasiswaapps.data.datasource.local

import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.common.utils.toListStudents
import com.team1.datamahasiswaapps.common.utils.toStudentEntityWithId
import com.team1.datamahasiswaapps.common.utils.toStudentEntityWithoutId
import com.team1.datamahasiswaapps.common.utils.toStudents
import com.team1.datamahasiswaapps.data.LocalCRUDRepository
import com.team1.datamahasiswaapps.data.datasource.local.room.dao.StudentsDao
import com.team1.datamahasiswaapps.domain.model.Students
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class LocalCRUDImpl(private val localStudentsDao: StudentsDao) : LocalCRUDRepository {
    override suspend fun localGetAllStudentsData(): Flow<ResourcesState<List<Students>>> = flow {
        emit(ResourcesState.Loading)
        try {
            val localStudentsData = localStudentsDao.getAllData()
            if(localStudentsData!=null){
                emitAll(localStudentsData.map {
                    ResourcesState.Success(it.toListStudents())
                })
            }else{
                ResourcesState.Error("Data Masih Kosong")
            }

        } catch (e: Exception) {
            emit(ResourcesState.Error(e.localizedMessage ?: "Error Read Data From Local Database"))
        }
    }

    override suspend fun localAddStudentData(dataInput: Students) {
        localStudentsDao.addStudentData(dataInput.toStudentEntityWithoutId())
    }

    override suspend fun localUpdatedStudentData(newUsername: String, newAddress: String, id: Int) {
        localStudentsDao.updateDataStudent(newUsername,newAddress,id)
    }


    override suspend fun localDeletedStudentData(dataInput: Students) {
        localStudentsDao.deleteDataStudent(dataInput.toStudentEntityWithId())
    }

    override suspend fun localGetDetailStudentData(id: Int): Flow<ResourcesState<Students>> {
        return flow {
            emit(ResourcesState.Loading)
            try {
                val localDataDetail = localStudentsDao.getDetailStudentData(id)
                emitAll(localDataDetail.map {
                    ResourcesState.Success(it.toStudents())
                })
            } catch (e: Exception) {
                emit(
                    ResourcesState.Error(
                        e.localizedMessage ?: "Error Read Data Detail From Local Database"
                    )
                )
            }
        }
    }

}