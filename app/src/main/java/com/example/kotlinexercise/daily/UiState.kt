package com.example.kotlinexercise.daily

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: String) : UiState()
    data class Error(val message: String) : UiState()
}

fun getMessage(state: UiState): String {
    return when (state) {
        is UiState.Loading -> "Loading..."
        is UiState.Success -> "Success: ${state.data}"
        is UiState.Error -> "Error: ${state.message}"
    }
}

fun main() {
    println(getMessage(UiState.Loading))
    println(getMessage(UiState.Success("User data loaded")))
    println(getMessage(UiState.Error("network error")))
}