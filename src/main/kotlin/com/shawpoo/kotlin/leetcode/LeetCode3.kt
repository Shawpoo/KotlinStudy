package com.shawpoo.kotlin.leetcode

import java.lang.Integer.max

/*
    描述：
    给定一个字符串，找到最长子串的长度，而不重复字符。

    例子：
    给定"abcabcbb"的答案是"abc"，长度是3。
    给定"bbbbb"的答案是"b"，长度为1。
    给定"pwwkew"的答案是"wke"，长度为3.请注意，答案必须是子字符串，"pwke"是子序列，而不是子字符串。
 */
fun main() {
    val str = "pwwkewdddaa2345dssddcs3"

    var test = test(str)
    println("${test.first} ${test.second}")
}

private fun test(str: String): Pair<Int, String> {
    if (str.isEmpty()) {
        return Pair(0, "")
    }
    var maxLength = 0
    var maxStr = ""
    val list = mutableListOf<Char>()

    for (c in str) {
        if (list.contains(c)) {
            maxLength = max(maxLength, list.size)
            maxStr = if (maxStr.length > list.size) maxStr else list.joinToString("")
            list.clear()
        }
        list.add(c)
    }
    maxStr = if (maxStr.length > list.size) maxStr else list.joinToString("")
    return Pair(max(maxLength, list.size), maxStr)
}
