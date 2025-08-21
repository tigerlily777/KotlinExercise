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
    // 1. use copy to create a new User object with updated name
    println("Original: $original")
    println("Updated: $updated")

    val users = listOf(
        User(1, "Alice", 16),
        User(2, "Bob", 22),
        User(3, "Tiger", 30),
        User(4, "Lily", 18)
    )

    // 2. use filter to get a list of users older than 18
    val adults: List<User> = users.filter {
        user -> user.age > 18
    }

    // 3. use map to get a list of names of the users older than 18
    val names: List<String> = adults.map {
        user -> user.name
    }

    println("Adults: $adults")
    println("Adult names: $names")
}