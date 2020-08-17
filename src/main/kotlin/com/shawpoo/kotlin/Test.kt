package com.shawpoo.kotlin

fun main() {
    var a = 3
    var b = 6
    test { what: Int, message: String ->
        println("what: $what, message: $message")
        a
    }

    test2(object : OnListener {
        override fun onCall(what: Int, message: String): Int {
            println("what: $what, message: $message")
            return b
        }
    })

    var intArray1 = arrayOf(1, "$", 2, 3)
    var intArray4 = intArrayOf(5, 3)
    var intArray3 = Array(5) {
        "222"
    }
    var intArray2 = IntArray(5) {
        it
    }
    println(intArray1.joinToString())
    println(intArray4.joinToString())
    println(intArray3.joinToString())
    println(intArray2.joinToString())

    var plusArray = intArray2.plus(100)
    println("plusArray: ${plusArray.joinToString()}")

    Pair(1, 2).first
    Triple("x", 3, 4).third

    var (x, y, z) = getTriple()
    println("x = $x, y = $y, z = $z")


    val lambda = { str: String ->
        str.length
    }

    println("hello".capitalizeEnd())

}

fun String.capitalizeEnd(): String {
    return if (this.isEmpty()) {
        ""
    } else {
        var charArray = this.toCharArray()
        charArray[length - 1] = charArray[length - 1].toUpperCase()
        String(charArray)
    }
}

fun getTriple(): Triple<Int, Long, String> {
    return Triple(1, 33333, "aaa")
}

private fun test(block: (what: Int, message: String) -> Int) {
    var what = 5
    var message = "this is a message"
    println("start call block")
    var b = block(what, message)
    println("b的值是$b")
}

interface OnListener {
    fun onCall(what: Int, message: String): Int
}

private fun test2(listener: OnListener) {
    var what = 4
    var message = "this is a message2"
    var b = listener.onCall(what, message)
    println("b2的值是$b")
}