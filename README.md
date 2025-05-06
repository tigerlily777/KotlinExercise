# This repo is for some kotlin daily exercise and code examples. 

## Scope function

### 🌟 let 

let typical usage：

✅ do something to an object and return result（but not object）。

基本语法：
```kotlin
val result = obj.let {
    // it 是 obj
    // do something with it
    ...
    returnResult
}
```
• it：代表当前这个对象。
• 返回值：是 let 的最后一行表达式。

✅ Example:
 ```kotlin
val name = "Alice"
val greeting = name.let {
    println("Original name: $it")
    "Hello, $it!"
}
println(greeting)
```
output:
```
Original name: Alice
Hello, Alice!
```
✅ Typical usecase：safe call + chain
```kotlin
val name: String? = "Eve"

name?.let {
    println("Name is not null: $it")
}
```
check null safety
Only execute when name is not null.



### run
👉 执行一段代码块，并返回代码块的结果
Execute a block of code and return result.

normal 2 usecases:
✅ 用法一：对象调用 run {}（常用于链式操作）
```kotlin
data class User(var name: String, var age: Int)

val user = User("Alice", 20)

val description = user.run {
    name = "Bob"
    age += 1
    "Name: $name, Age: $age"
}

println(description)  // 输出: Name: Bob, Age: 21
```
	• 作用对象：this
	• 返回值：最后一行表达式的值
	• 常见用途：初始化配置、计算结果、链式调用

✅ 用法二：无作用对象的 run {}（当作用域函数）
```kotlin
val result = run {
    val a = 10
    val b = 20
    a + b
}

println(result)  // 输出: 30
```
	• 没有对象调用，直接作为代码块作用域来使用
	• 适合用来包裹局部作用域的变量，防止污染外部变量命名空间

 ### 🔧Apply
 
✅ 适合用来配置对象的属性，返回对象本身。

基本语法：
```kotlin
val obj = MyClass().apply {
    // this 表示 obj 本身
    property1 = ...
    property2 = ...
}
```
✅ 一个例子：✅ 典型场景：对象配置
```kotlin
data class User(var name: String, var age: Int)

fun main() {
    val user = User("Default", 0).apply {
        name = "Alice"
        age = 25
    }

    println(user)
}
```
	• apply 里你可以直接修改属性。
	• 它返回的还是 User，非常适合做“初始化+返回”的事情。





























































































