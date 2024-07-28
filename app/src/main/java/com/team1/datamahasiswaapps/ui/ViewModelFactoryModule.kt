package com.team1.datamahasiswaapps.ui

import com.team1.datamahasiswaapps.ui.viewmodel.AddItemFragmentViewModel
import com.team1.datamahasiswaapps.ui.viewmodel.DetailFragmentViewModel
import com.team1.datamahasiswaapps.ui.viewmodel.EditFragmentViewModel
import com.team1.datamahasiswaapps.ui.viewmodel.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinViewModel = module {
    viewModel {
        AddItemFragmentViewModel(useCase = get())
    }
    viewModel {
        HomeFragmentViewModel(useCase = get())
    }
    viewModel {
        DetailFragmentViewModel(useCase = get())
    }
    viewModel {
        EditFragmentViewModel(useCase = get())
    }
}