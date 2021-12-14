package com.example.marvel.christmasapplication.util

sealed class States<out T> {
    object Loading: States<Nothing>()

    data class Success<out T>(
        val data: T
    ): States<T>()

    data class Error(
        val message: String
    ): States<Nothing>()
}