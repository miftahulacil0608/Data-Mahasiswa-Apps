package com.team1.datamahasiswaapps.data.datasource.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentsDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id:Int?=null,
    @ColumnInfo( name ="username")
    val username:String,
    @ColumnInfo(name="nim")
    val nim:Long,
    @ColumnInfo(name="faculty")
    val faculty:String,
    @ColumnInfo(name="major")
    val major:String,
    @ColumnInfo(name="address")
    val address:String,
)
