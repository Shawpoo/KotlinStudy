package com.shawpoo.kotlin

fun main() {
    val value = "HelloWord"

//    println("$value kotlin")
//
//    println(value - "Word")
//
//    val str = "*"
//    println(str * 20)
//
//    println(value / "l")

    val aa = "I ❤️ You\n"
    println("${aa * 5}")
}

operator fun String.minus(right: Any?): String {
    return this.replaceFirst(right.toString(), "")
}

operator fun String.times(right: Int): String {
    return (1..right).joinToString("") {
        this
    }
}

operator fun String.div(right: Any?): Int {
    val right = right.toString()
    return this.windowed(right.length, 1) {
        it == right
    }.count { it }
}