package com.shawpoo.kotlin.leetcode

/*
 两数之和
 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那俩个整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
fun main() {

    val array = intArrayOf(2, 7, 11, 15)

    println(test2(array, 22).joinToString(" "))

}

private fun test(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    for (i in nums.indices) {
        for (j in (i + 1) until nums.size) {
            if (nums[i] + nums[j] == target) {
                result[0] = nums[i]
                result[1] = nums[j]
                println("index1: $i, index2: $j")
            }
        }
    }
    return result
}

private fun test2(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val map = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        val key = target - nums[i]
        println("key: $key, value: ${map[key]}")
        if (map[key] != null) {
            result[0] = map[key]!!
            result[1] = i
            return result
        }
        map[nums[i]] = i
    }
    return result
}
