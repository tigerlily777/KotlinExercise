package com.example.kotlinexercise


class Person(
    var name: String,
    var age: Int,
    var city: String
) {
    fun moveTo(newCity: String) {
        city = newCity
    }

    fun incrementAge() {
        age++
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age, city='$city')"
    }
}

fun main() {
    letExample()
    withoutLetExample()

    runExample1()
    runExample2()
}

fun letExample() {
    Person("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }
}

fun withoutLetExample() {
    val person = Person("Alice", 20, "Amsterdam")
    println(person)
    person.moveTo("London")
    person.incrementAge()
    println(person)
}

/**
 * 用法一：对象调用 run {}（常用于链式操作）
 * 	•	作用对象：this
 * 	•	返回值：最后一行表达式的值
 * 	•	常见用途：初始化配置、计算结果、链式调用
 **/
fun runExample1() {
    val person = Person("Alice", 20, "Amsterdam")

    val description = person.run {
        name = "Bob"
        age += 1
        "Name: $name, Age: $age"
    }
    println(description)
}

/**
 * 用法二：run {} 作为函数调用（常用于局部作用域）
 * 	•	作用对象：this
 * 	•	返回值：最后一行表达式的值
 * 	•	常见用途：局部作用域、计算结果
 **/
fun runExample2() {
    val result = run {
        val a = 5
        val b = 10
        a + b
    }
    println("Result of run_2: $result")
}

