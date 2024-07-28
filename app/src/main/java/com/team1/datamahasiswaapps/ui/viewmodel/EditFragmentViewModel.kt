package com.team1.datamahasiswaapps.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team1.datamahasiswaapps.domain.UseCase
import com.team1.datamahasiswaapps.domain.model.Students
import kotlinx.coroutines.launch

class EditFragmentViewModel(val useCase: UseCase): ViewModel() {
    fun updateStudentsData(newUsername:String,newAddress:String,id: Int){
        viewModelScope.launch {
            useCase.updateStudentsData(newUsername,newAddress,id)
        }
    }
}