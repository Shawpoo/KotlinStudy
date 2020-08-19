package com.shawpoo.kotlin.function

/*
infix函数需要几个条件:
- 只有一个参数（参数不能是可变参数或默认参数）
- 在方法前必须加infix关键字
- 必须是成员方法或者扩展方法
 */
fun main() {
    val test = InfixTest()

    println(test add 1000)
}

class InfixTest {

    infix fun add(sum: Int): Int {
        return sum + 100
    }

}
