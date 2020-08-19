package com.shawpoo.kotlin.leetcode

import java.lang.Integer.max

/*
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    描述：
    给定一个字符串，找到最长子串的长度，而不重复字符。

    例子：
    给定"abcabcbb"的答案是"abc"，长度是3。
    给定"bbbbb"的答案是"b"，长度为1。
    给定"pwwkew"的答案是"wke"，长度为3.请注意，答案必须是子字符串，"pwke"是子序列，而不是子字符串。
 */
fun main() {
    val str = "dv12df"

    println(test(str))
}

private fun test(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }
    var maxLength = 0
    val list = mutableListOf<Char>()

    for (c in s) {
        if (list.contains(c)) {
            maxLength = max(maxLength, list.size)
            list.clear()
        }
        list.add(c)
    }
    return max(maxLength, list.size)
}
