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































