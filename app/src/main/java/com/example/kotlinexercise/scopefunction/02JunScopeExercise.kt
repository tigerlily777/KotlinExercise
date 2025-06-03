package com.example.kotlinexercise.scopefunction

data class User(var name: String, var age: Int)

fun main() {
    val user = User("Tiger", 30)

    // let：返回表达式结果
    val letResult = user.let {
        it.age += 1
        "Name: ${it.name}, Age: ${it.age}"
    }

    // run：this作用域，返回表达式结果
    val runResult = user.run {
        age += 1
        "Name: $name, Age: $age"
    }

    // apply：this作用域，返回对象本身
    val applyResult = user.apply {
        age += 1
    }

    println("let => $letResult")
    println("run => $runResult")
    println("apply => $applyResult") // apply 返回的是对象
}