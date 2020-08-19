package com.shawpoo.kotlin.leetcode
// https://leetcode-cn.com/problems/roman-to-integer/

fun main() {

    println(romanToInt("III"))
    println(romanToInt("IV"))
    println(romanToInt("IX"))
    println(romanToInt("LVIII"))
    println(romanToInt("XCIX"))
    println(romanToInt("MCMXCIV"))

}

private fun romanToInt(s: String): Int {
    var result = 0
    if (s.isEmpty()) {
        return result
    }

    val hashMap = hashMapOf<Char, Int>(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var array = s.toCharArray()
    var i = 0
    while (i < array.size) {
        var c = array[i]
        var c2: Char? = null
        if (i + 1 < array.size) {
            c2 = array[i + 1]
        }
        when (c) {
            'M', 'D', 'L', 'V' -> {
                result += hashMap[c]!!
                i++
            }
            'I' -> {
                if (c2 != null && c2 == 'V') {
                    result += 4
                    i += 2
                } else if (c2 != null && c2 == 'X') {
                    result += 9
                    i += 2
                } else {
                    result += hashMap[c]!!
                    i++
                }
            }
            'X' -> {
                if (c2 != null && c2 == 'L') {
                    result += 40
                    i += 2
                } else if (c2 != null && c2 == 'C') {
                    result += 90
                    i += 2
                } else {
                    result += hashMap[c]!!
                    i++
                }
            }
            'C' -> {
                if (c2 != null && c2 == 'D') {
                    result += 400
                    i += 2
                } else if (c2 != null && c2 == 'M') {
                    result += 900
                    i += 2
                } else {
                    result += hashMap[c]!!
                    i++
                }
            }
            else -> {
                i++
            }
        }
    }

    return result
}