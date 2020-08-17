package com.shawpoo.kotlin

fun main(vararg args: String) {
    if (args.size < 3) {
        return showHelp()
    }

    val operators = mapOf(
        "+" to ::plus,
        "-" to ::minus,
        "*" to ::times,
        "/" to ::div
    )

    val op = args[1]
    val opFunc = operators[op] ?: return showHelp()

    try {
        println("Input: ${args.joinToString(" ")}")
        println("Output: ${opFunc(args[0].toInt(), args[2].toInt())}")
    } catch (e: Exception) {
        println("Invalid arguments.")
    }

//    val sum: (Int, Int) -> Int = { x, y -> x + y }
    fun sum2(x: Int, y: Int) = x - y

    fun applyOp(x: Int, y: Int, op: (Int, Int) -> Int): Int = op(x, y)

    println(applyOp(2, 3, ::sum2))


}

private fun plus(arg0: Int, arg1: Int): Int {
    return arg0 + arg1
}

private fun minus(arg0: Int, arg1: Int): Int {
    return arg0 - arg1
}

private fun times(arg0: Int, arg1: Int): Int {
    return arg0 * arg1
}

private fun div(arg0: Int, arg1: Int): Int {
    return arg0 / arg1
}

private fun showHelp() {
    println(
        """
        Simple Calculator.
            Input x * y,
            Output: z
    """.trimIndent()
    )
}
