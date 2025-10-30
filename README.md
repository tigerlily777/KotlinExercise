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

### 🔹 also
also 是一个 作用于对象本身 的 Scope Function，它的语法和 apply 类似，但用途不同, 通常在 also 里做副作用操作，比如：打印、日志、调试。
✅ Example：
```kotlin
data class User(var name: String, var age: Int)

fun main() {
    val user = User("Alice", 20).also {
        println("原始用户信息：$it")
        it.age += 1
    }

    println("更新后用户信息：$user")
}
```
output:
```
原始用户信息：User(name=Alice, age=20)
更新后用户信息：User(name=Alice, age=21)
```
	• apply 是「主语风格」：我（this）来做某事，主语自己处理事情。
	• also 是「宾语风格」：它（it）做了一些副作用动作，但主语不变。
 ✅ 修正点
	1.	多次使用 also：要链式调用 .also { ... }.also { ... }.also { ... }

 Example
 ```kotlin
data class Task(var name: String, var isDone: Boolean)

fun main() {
    val task = Task("Learn also", false)
        .also {
            println("初始状态：$it")
        }
        .also {
            it.isDone = true
            println("second also：$it")
        }
        .also {
            it.name = "Finished"
            println("third also：$it")
        }

    println("最终结果：$task")
}
```
### 🔹 with 是什么？
with 是一个非扩展函数，用于对某个对象执行多项操作。
它不是调用者调用的，而是你传入对象，然后在 block 中使用 this 操作它。
✅ 语法：
```kotlin
with(obj) {
    // this 是 obj
    // 可以访问属性、调用方法
    ...
    returnResult
}
```
	•	this：代表 obj
	•	返回值：最后一行表达式的值
✅ 示例
```kotlin
data class User(var name: String, var age: Int)

fun main() {
    val user = User("Alice", 20)

    val description = with(user) {
        println("Name: $name")
        println("Age: $age")
        "User($name, $age)" // 最后一行作为返回值
    }

    println(description)  // 输出：User(Alice, 20)
}
```
和 run 有点像，但不同之处是：
with 是 with(obj) { ... }
而 run 是 obj.run { ... }

✅ 常用场景
场景: 对一个对象做多项操作
用法: with(obj) { prop1 = ..., method(), ... }

场景: 更清晰地组织初始化逻辑
用法: 尤其适合老的 Java 对象，比如 TextPaint、Canvas

更像是**“把对象交给代码块来处理”**

### 🌱 小总结口诀（Scope Functions 五兄弟）：
let 看 it，run 和 with 看 this，
apply 和 also 返回自己。
run/with 返回最后一行，apply/also 返回原对象。

### Test
1. There's a data class Car:
```data class Car(var brand: String, var model: String, var year: Int)```

   expected output:
   "This is a 2023 Tesla Model 3."

   Please complete this function:
```kotlin
   fun main() {
    val car = Car("Tesla", "Model 3", 2023)

    val description = // 用 with 构建这个字符串 👇

    println(description)
}
```








Answer:
Q1:
```kotlin
fun main() {
    val car = Car("Tesla", "Model 3", 2023)

    val description = with(car) {
        "This is a $year $brand $model."
    }

    println(description)
}
```


## ✅ lateinit & by lazy 完整对比⚡

lateinit 只能 var, 不可为 null, 手动稍后赋值, Android View / DI（需要先创建对象）,未初始化会抛异常
val by lazy {} 只能 Val, 不可为 null, 第一次访问时自动计算, 重成本对象或计算（避免浪费）,一定已初始化
lateinit 适用于必须之后赋值但在使用前一定会完成初始化的对象。
lazy 则用于昂贵对象的延迟构建执行，只执行一次。


## ✅ inline function — 高级但高频问法！
📌 一句话概念

编译器会把函数体展开到调用处 → 没有真正的函数调用

📌 为啥？
✅ 消除高阶函数带来的开销
✅ 避免创建 lambda 对象
✅ 在多次调用的小函数上性能受益明显

```
inline fun runTwice(block: () -> Unit) {
    block()
    block()
}
```

noinline → 不想被 inline 的 lambda
crossinline → 禁止 return 跳出外层


✅ 用一句话总结区别

LaunchedEffect 做“一次性启动任务”，
SideEffect 做“外部副作用同步”，
DisposableEffect 做“清理工作”，
rememberUpdatedState 确保副作用中的值最新。

✅ Usecase：**LaunchedEffect**

```
@Composable
fun FetchUserScreen(userId: String) {
    val viewModel: UserViewModel = viewModel()

    LaunchedEffect(userId) {
        viewModel.loadUser(userId)
    }
}
```
🔹 userId 变了才会重新触发
🔹 避免因为 recomposition 导致重复请求 API

✅ Usecase：SideEffect 
```
@Composable
fun UpdateTitle(name: String) {
    SideEffect {
        Log.d("TAG", "UI updated with $name")
    }
}
```
🔹 recomposition 会重复运行
🔹 用来和外部系统同步，而不是启动协程

✅ DisposableEffect
```
@Composable
fun LocationListener() {
    DisposableEffect(Unit) {
        val listener = startLocation()

        onDispose {
            stopLocation(listener)
        }
    }
}
```
🔹 相当于 Android onStart + onStop
🔹 非常适合监听注册和注销！

✅ rememberUpdatedState 小例子
```
@Composable
fun TimerEffect(onTimeOut: () -> Unit) {
    val latestCallback by rememberUpdatedState(onTimeOut)

    LaunchedEffect(Unit) {
        delay(5000)
        latestCallback() // 始终执行最新 callback
    }
}
```



















































































































