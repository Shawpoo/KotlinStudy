package com.shawpoo.kotlin.singleton


object Singleton {

    @JvmField
    val x: Int = 2

    fun y() {
        println("hello singleton!")
    }

    object InnerObject {
        val xxx = 35
    }

}

class SimpleSingleton {

    @JvmField
    val xx: Int = 3

}


fun main() {
}