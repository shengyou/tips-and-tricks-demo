# Functions

## 簡介

* `function` 是許多程式語言的核心，把一些動作放到一個 function 後可以做一系列的動作。
* 假如您需要再次做一樣動作時，你只需要呼叫這個 function 即可，而不是重複地複製貼上一樣的程式碼。

## 定義一個 Function

```kotlin
fun printMyName() {
    println("My name is Shengyou Fan.")
}
``` 

* 用 `fun` 關鍵字
* 一定要有 `()`
* 一定要用 `{}` 把程式碼包起來

## 定義 Function parameters

```kotlin
fun printMultipleOfFive(value: Int) {
    println("$value * 5 = ${value * 5}")
}

fun printMultipleOf(multiplier: Int, andValue: Int) {
    println("$multiplier * $andValue = ${multiplier * andValue}")
}

fun printMultipleOf(multiplier: Int, value: Int = 1) {
    println("$multiplier * $value = ${multiplier * value}")
}
```

* 把 parameter 放在 `()` 裡面
* 每一個 parameter 都是 `名字: 型別` 的組合
* 假如要給 parameter 預設值的話，直接在後面寫成 `名字: 型別 = 預設值`

## 定義 Return value

```kotlin
fun multiply(number: Int, muliplier: Int): Int {
    return number * muliplier
}
```

* 在 function 的最後一行用 `return` 關鍵字回傳處理過的資料
* 在 `)` 後面用 `: 型別` 做回傳值的型別定義
* 假如沒有 return 東西的話，可以不定義回傳型別，或是回傳 `Unit`

```kotlin
fun multiplyAndDivide(number: Int, factor: Int): Pair<Int, Int> {
    return Pair(number * factor, number / factor)
}
val (product, quotient) = multiplyAndDivide(4, 2)
```

* 可以用 Pair 物件來回傳多個值
* Function 回傳後，可以直接放在 expression 裡做 assign

## 呼叫 Function

```kotlin
printMyName()
printMyName(firstName = "Shengyou", lastName = "Fan")
```

* 直接寫 function 的名稱 + `()` 即可
* 也可以把 parameters 的名字一起寫上去，這樣會有一些額外的好處：
  - 假如 parameter 很多的時候 會知道這些 parameter 各自是什麼？
  - 假如你有指定 parameter 的話，還可以調整順序而不出錯。

## 把 function 指定成變數 (a.k.a functional programming)

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}

var function = ::add

function(4, 2)

// 把 function 當成參數傳遞
fun printResult(function: (Int, Int) -> Int, a: Int, b: Int) {
    val result = function(a, b)
    print(result)
}

printResult(::add, 4, 2)
```

* 我們可以用 `::` 語法將 function 存在一個變數裡
* 甚至也可以把 function 當成另外一個 function 的參數
* 這可以讓程式寫法變得更加彈性 (🧠想要找個更實際一點的案例)，也就是所謂 functional programming 的寫法
* 🧠在 PHP 裡，這不就是 closure 的寫法嗎？

## 特點及可能的坑

1. 假如 function 的內容只有一行的話，可以直接用 `=` 來定義 function 的內容

    ```Kotlin
    fun multiplyInferred(number: Int, multiplier: Int) = number * multiplier
    ```
   
2. Function parameters 預設是以常數的方式存在，即不可以隨意改變。若想要修改的話，請宣告一個新的變數來做調整。

    ```kotlin
       fun incrementAndPrint(value: Int) {
           value += 1 // 不可以修改 parameter 的值！
       }
   
       fun incrementAndPrint(value: Int) {
           val newValue = value + 1
           println(newValue)
           return newValue
       }
    ```

3. 兩個同名的 function 可以透過 `不同數量的 parameter` 、 `不同 parameter 的型別` 來做區別，Kotlin 的 compiler 可以識別出差異，這個功能叫 `overloading`。但要注意的是，若兩個 function 只差在回傳的型別不同的話，是沒辦法 overloading 的！

    ```kotlin
    // 可以 overloading
    fun getValue(value: Int): Int {
        return value + 1
    }
    
    fun getValue(value: String): String {
        return "The value is $value"
    }
   
    // 不可以 overloading
   fun getValue(value: String): String {
       return "The value is $value"
   }
   
   fun getValue(value: String): Int {
       return value.length
   }
    ```
4. 有時會需要一種永不停止且不回傳的 function，也就是所謂的 event loop，回傳型別請設定成 `Nothing`。看起來很多餘，但對於 compiler 來說，這樣可以知道該 function 不會停止也不會回傳反而可以針對運行做最佳化。最常見的案例應該就是 command line interface 或 Android 的 `main thread` 也就是所謂的 `UI thread`。 

    ```kotlin
    fun infiniteLoop(): Nothing {
        while (true) {
            // ...
        }
    }
    ```
  
## 最佳實踐

* 只做非常簡單的事，愈小愈好。
* 容易了解與記憶的 function 名稱。
* 定義明確的輸入值且相同的輸出值。
* 以上的一切都是為了方便重覆組合成大程式，也好隔離和測試。

## 重點回顧

* 您用 `function` 定義一項任務，這樣您就可以重覆執行多次而不必複製貼上相同的程式碼。
* 可以定義 `function` 有 0 到多個 parameter，而回傳值是可選擇性的。
* 為了讓呼叫時可以更明確，您可以在呼叫 function 時指定 parameter 的名稱和順序。
* 定義 parameter 的預設值會讓 function 更容易使用，也可以少寫一些程式碼。
* function 定義可以有相同名稱但不同的參數設定，這就叫 overloading。
* 您可以將 function 指定給變數也可以傳遞給另一個 function。
* function 可以定義 Nothing 這種特殊的回傳類型來告訴 Kotlin compiler 這個 function 永不停止。
* 記得在定義 function 時請給它一個清楚的名字、單一工作、重複且一致的輸入輸出。

## 官方文件

* https://kotlinlang.org/docs/reference/functions.html

## 參考資料
