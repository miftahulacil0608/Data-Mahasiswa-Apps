package com.team1.datamahasiswaapps.common.utils

object Validator {
    fun isNotEmpty(input: String): Boolean {
        return input.isNotEmpty()
    }

    fun isNameValid(name: String): Boolean {
        return name.length >= 3
    }

    fun isNimValid(nim: String): Boolean {
        return nim.length == 12 && nim.all { it.isDigit() }
    }

    fun isFacultyValid(faculty: String): Boolean {
        return faculty.length >= 3
    }

    fun isMajorValid(major: String): Boolean {
        return major.length >= 3
    }

    fun isAddressValid(address: String): Boolean {
        return address.length >= 20
    }
}