package com.shawpoo.kotlin

fun main() {
    val list = listOf("kotlin", "android", "php", "gradle", "java", "scala")
    println(list)
    println(list.maxBy { it.length })
    println(list.maxBy { it })
    println(list.findMax { it.length })
}

fun <T, R : Comparable<R>> List<T>.findMax(block: (T) -> R): T? {
    if (isEmpty()) {
        return null
    }
    var maxElement = get(0)
    var maxValue = block(maxElement)
    println(maxValue)
    for (element in this) {
        val value = block(element)
        if (value > maxValue) {
            maxElement = element
            maxValue = value
        }
    }
    return maxElement
}