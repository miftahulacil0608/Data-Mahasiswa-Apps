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

class HomeFragmentViewModel(val useCase: UseCase) : ViewModel() {

    private val _listStudentsData: MutableStateFlow<ResourcesState<List<Students>>> =
        MutableStateFlow(ResourcesState.Idle)
    val listStudentsData: StateFlow<ResourcesState<List<Students>>> =
        _listStudentsData.asStateFlow()

    fun getAllStudentsData() {
        viewModelScope.launch {
            useCase.getAllStudentsData().collect {
                when (it) {
                    is ResourcesState.Loading -> {
                        _listStudentsData.value = ResourcesState.Loading
                    }

                    is ResourcesState.Success -> {
                        _listStudentsData.value = ResourcesState.Success(it.data)
                    }

                    is ResourcesState.Error -> {
                        _listStudentsData.value = ResourcesState.Error(it.message)
                    }

                    is ResourcesState.Idle -> {}
                }
            }
        }
    }


}