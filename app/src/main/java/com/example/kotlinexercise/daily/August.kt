package com.example.kotlinexercise.daily

data class User(
    val id: Int,
    val name: String,
    val age: Int
)


fun main1() {
    val original = User(1, "Tiger", 30)

    // generate a new User object with updated name
    val updated = original.copy(
        name = "Tigerlily777"
    )
    // 1. use copy to create a new User object with updated name
    println("Original: $original")
    println("Updated: $updated")
}

fun main2() {
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

// 4. Extension function to mask phone number
fun String.maskPhone(): String {
    // TODO: if the string is a valid phone number (11 digits), mask the middle 4 digits
    // e.g "13812345678" -> "138****5678"
    if (this.length == 11 && this.all { it.isDigit() }) {
        return this.substring(0, 3) + "****" + this.substring(7)
    }
    return this // if not a valid phone number, return the original string
}

fun main() {
    val phone1 = "13812345678"
    val phone2 = "12345" // 测试非标准手机号

    println(phone1.maskPhone()) // 预期输出: 138****5678
    println(phone2.maskPhone()) // 预期输出: 12345 (不做处理)
}