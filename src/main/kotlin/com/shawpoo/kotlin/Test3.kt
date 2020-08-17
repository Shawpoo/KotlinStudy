package com.shawpoo.kotlin

fun main() {
    var list = listOf(1, 3, 4, 8)

    list.map {
        it * 2
    }.forEach(::println)
}

