package com.team1.datamahasiswaapps.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team1.datamahasiswaapps.domain.UseCase
import com.team1.datamahasiswaapps.domain.model.Students
import kotlinx.coroutines.launch

class AddItemFragmentViewModel(val useCase: UseCase):ViewModel() {
    fun addStudentsData(data:Students){
        viewModelScope.launch {
            useCase.addStudentsData(data)
        }
    }
}