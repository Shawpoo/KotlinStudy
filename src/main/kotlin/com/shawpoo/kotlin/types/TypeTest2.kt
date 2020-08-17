package com.shawpoo.kotlin.types

fun main() {
    val pair = "Hello" to "World"

    val list = List.Cons(1.0, List.Nil)
}


interface Book

interface EduBook : Book

class BookStore<out T : Book> {
    fun getBook(): T {
        TODO()
    }
}

fun covariant() {
    val eduBookStore: BookStore<EduBook> = BookStore<EduBook>()
    val bookStore: BookStore<Book> = eduBookStore

    val book: Book = bookStore.getBook()
    val eduBook: EduBook = eduBookStore.getBook()
}


open class Waste

class DryWaste : Waste()

class Dustbin<in T : Waste> {
    fun put(t: T) {
        TODO()
    }
}

fun contravariant() {
    val dustbin: Dustbin<Waste> = Dustbin<Waste>()
    val dryWasteDustbin: Dustbin<DryWaste> = dustbin

    val waste = Waste()
    val dryWaste = DryWaste()

    dustbin.put(waste)
    dustbin.put(dryWaste)

//    dryWasteDustbin.put(waste)
    dryWasteDustbin.put(dryWaste)
}


sealed class List<out T> {
    object Nil : List<Nothing>() {
        override fun toString(): String {
            return "Nil"
        }
    }

    data class Cons<T>(val head: T, val tail: List<T>) : List<T>() {
        override fun toString(): String {
            return "$head, $tail"
        }
    }

    fun joinToString(sep: Char = ','): String {
        return when (this) {
            Nil -> "Nil"
            is Cons -> "${this.head}$sep${this.tail.joinToString(sep)}"
        }
    }
}

operator fun <T> List<T>.get(index: Int): T =
    when {
        index == 0 && this is List.Cons<T> -> this.head
        index > 0 && this is List.Cons<T> -> this.tail[index - 1]
        else -> throw IndexOutOfBoundsException()
    }