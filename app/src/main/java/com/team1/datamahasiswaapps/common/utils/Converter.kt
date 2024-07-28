package com.team1.datamahasiswaapps.common.utils

import com.team1.datamahasiswaapps.data.datasource.local.room.entity.StudentsDataEntity
import com.team1.datamahasiswaapps.domain.model.Students

fun StudentsDataEntity.toStudents(): Students {
    return Students(
        id = id,
        username = username,
        nim = nim,
        faculty = faculty,
        major = major,
        address = address
    )
}

fun List<StudentsDataEntity>.toListStudents(): List<Students> {
    return this.map {
        Students(
            id = it.id,
            username = it.username,
            nim = it.nim,
            faculty = it.faculty,
            major = it.major,
            address = it.address
        )
    }
}

fun Students.toStudentEntityWithoutId(): StudentsDataEntity {
    return StudentsDataEntity(
        username = username,
        nim = nim,
        faculty = faculty,
        major = major,
        address = address,
    )
}

fun Students.toStudentEntityWithId(): StudentsDataEntity {
    return StudentsDataEntity(
        id = id,
        username = username,
        nim = nim,
        faculty = faculty,
        major = major,
        address = address,
    )
}