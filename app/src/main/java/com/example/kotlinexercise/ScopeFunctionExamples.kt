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
    letExample()
    withoutLetExample()

    runExample_1()
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

fun runExample_1() {
    val person = Person("Alice", 20, "Amsterdam")

    val description = person.run {
        name = "Bob"
        age += 1
        "Name: $name, Age: $age"
    }
    println(description)
}
