package com.team1.datamahasiswaapps.data

import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.data.datasource.local.LocalCRUDImpl
import com.team1.datamahasiswaapps.domain.model.Students
import com.team1.datamahasiswaapps.domain.repository.CRUDRepository
import kotlinx.coroutines.flow.Flow

class CRUDRepositoryImpl(val localCRUDImpl: LocalCRUDRepository) : CRUDRepository {
    override suspend fun getAllStudentsData(): Flow<ResourcesState<List<Students>>> {
        return localCRUDImpl.localGetAllStudentsData()
    }

    override suspend fun addStudentData(dataInput: Students) {
        localCRUDImpl.localAddStudentData(dataInput)
    }

    override suspend fun updatedStudentData(newUsername: String, newAddress: String, id: Int) {
        localCRUDImpl.localUpdatedStudentData(newUsername, newAddress, id)
    }

    override suspend fun deletedStudentData(dataInput: Students) {
        localCRUDImpl.localDeletedStudentData(dataInput)
    }

    override suspend fun getDetailStudentData(id: Int): Flow<ResourcesState<Students>> {
        return localCRUDImpl.localGetDetailStudentData(id)
    }


}