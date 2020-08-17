package com.shawpoo.kotlin

open class SimpleClass {

}

interface SimpleInterface {

    val simpleProperty: Int

    fun simpleMethod()

}

class TestClass : SimpleClass(), SimpleInterface {

    override val simpleProperty: Int
        get() = 3

    override fun simpleMethod() {

    }

}