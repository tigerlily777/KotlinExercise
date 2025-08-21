package com.example.kotlinexercise.daily

data class User(
    val id: Int,
    val name: String,
    val age: Int
)

fun main() {
    val original = User(1, "Tiger", 30)

    // generate a new User object with updated name
    val updated = original.copy(
        name = "Tigerlily777"
    )

    println("Original: $original")
    println("Updated: $updated")
}