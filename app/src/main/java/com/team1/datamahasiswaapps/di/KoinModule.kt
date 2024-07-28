package com.team1.datamahasiswaapps.di

import android.content.Context
import androidx.room.Room
import com.team1.datamahasiswaapps.data.CRUDRepositoryImpl
import com.team1.datamahasiswaapps.data.LocalCRUDRepository
import com.team1.datamahasiswaapps.data.datasource.local.LocalCRUDImpl
import com.team1.datamahasiswaapps.data.datasource.local.room.AppDataBase
import com.team1.datamahasiswaapps.domain.UseCase
import com.team1.datamahasiswaapps.domain.repository.CRUDRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val koinModule = module {
    single<AppDataBase> {
        Room.databaseBuilder(
            context = androidContext().applicationContext,
            klass = AppDataBase::class.java,
            name = "studentDataBase"
        ).build()
    }
    single<LocalCRUDRepository> {
        LocalCRUDImpl(localStudentsDao = (get() as AppDataBase).studentsDao())
    }

    single<CRUDRepository> {
        CRUDRepositoryImpl(localCRUDImpl = get())
    }

    single<UseCase> {
        UseCase(crudRepository = get())
    }
}
