# This repo is for some kotlin daily exercise and code examples. 

## Scope function

### 🌟 let 

let 的典型用途是：

✅ 对某个对象做一些操作后，返回结果（不是对象本身）。

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
这个常用于处理 null 安全，只有 name 不为 null 才会执行 let。



### run































