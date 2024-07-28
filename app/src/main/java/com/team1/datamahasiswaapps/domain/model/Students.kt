package com.team1.datamahasiswaapps.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Students(
    val id:Int?=null,
    val username: String,
    val nim: Long,
    val faculty: String,
    val major: String,
    val address: String
):Parcelable
