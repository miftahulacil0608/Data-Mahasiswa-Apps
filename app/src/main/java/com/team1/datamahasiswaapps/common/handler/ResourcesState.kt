package com.team1.datamahasiswaapps.common.handler

sealed class ResourcesState<out R> {
    data object Loading : ResourcesState<Nothing>()
    data class Success<out T>(val data: T) : ResourcesState<T>()
    data class Error(val message: String) : ResourcesState<Nothing>()
    data object Idle : ResourcesState<Nothing>()
}