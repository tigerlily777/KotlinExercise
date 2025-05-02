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

fun main(){
    Person("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }
}