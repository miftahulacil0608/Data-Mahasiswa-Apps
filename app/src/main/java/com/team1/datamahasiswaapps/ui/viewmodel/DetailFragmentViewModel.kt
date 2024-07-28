package com.team1.datamahasiswaapps.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team1.datamahasiswaapps.common.handler.ResourcesState
import com.team1.datamahasiswaapps.domain.UseCase
import com.team1.datamahasiswaapps.domain.model.Students
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailFragmentViewModel(val useCase: UseCase) : ViewModel() {

    private val _studentsData: MutableStateFlow<ResourcesState<Students>> =
        MutableStateFlow(ResourcesState.Idle)
    val studentsData: StateFlow<ResourcesState<Students>> =
        _studentsData.asStateFlow()

    fun getStudentsDataDetail(id: Int) {
        viewModelScope.launch {
            useCase.getDetailStudentsData(id).collect {
                when (it) {
                    ResourcesState.Loading -> {
                        _studentsData.value = ResourcesState.Loading
                    }

                    is ResourcesState.Success -> {
                        _studentsData.value = ResourcesState.Success(it.data)
                    }

                    is ResourcesState.Error -> {
                        _studentsData.value = ResourcesState.Error(it.message)
                    }

                    ResourcesState.Idle -> {}
                }
            }
        }
    }

    fun deletedStudentsData(students: Students){
        viewModelScope.launch {
            useCase.deleteStudentsData(students)
        }
    }


}