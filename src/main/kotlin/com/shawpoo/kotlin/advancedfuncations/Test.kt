package com.shawpoo.kotlin.advancedfuncations

import java.io.File

fun main() {

    File("build.gradle").readText() // 读取文件
        .toCharArray() // 转成char
        .filterNot {
            it.isWhitespace() // 过滤非空字符
        }
        .groupBy {
            it // 以当前字符分组
        }
        .map {
            it.key to it.value.size // 分组后是个map, 通过map的key-value进行统计
        }
//        .let(::println)

    println(hashMapOf("color" to "red", "size" to "100px", "width" to "100px").joinStr())
}


fun <K : String, V : Any> HashMap<K, V>.joinStr(): String {
    var result = ""
    forEach {
        result += "${it.key}='${it.value}' "
    }
    return result
}