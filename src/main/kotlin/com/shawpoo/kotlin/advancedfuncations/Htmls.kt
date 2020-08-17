package com.shawpoo.kotlin.advancedfuncations

import java.io.File


interface Node {
    fun render(): String
}

class StringNode(val content: String) : Node {
    override fun render(): String {
        return content
    }
}

class BlockNode(val name: String) : Node {

    val children = ArrayList<Node>()
    val properties = HashMap<String, Any>()

    override fun render(): String {
//        return """<$name ${properties.map { "${it.key}='${it.value}'" }.joinToString(" ")}>
//            ${children.joinToString("") { it.render() }}
//            </$name>"""
        return """<$name ${properties.joinStr()}>
            ${children.joinToString("") { it.render() }}
            </$name>"""
    }

    // 自己玩一下扩展函数
    private fun <K : String, V : Any> HashMap<K, V>.joinStr(): String {
        var result = ""
        forEach {
            result += "${it.key}='${it.value}'"
        }
        return result
    }

    operator fun String.invoke(block: BlockNode.() -> Unit): BlockNode {
        val node = BlockNode(this)
        node.block()
        this@BlockNode.children += node
        return node
    }

    operator fun String.invoke(value: Any) {
        this@BlockNode.properties[this] = value
    }

    operator fun String.unaryPlus() {
        this@BlockNode.children += StringNode(this)
    }

}

fun html(block: BlockNode.() -> Unit): BlockNode {
    val html = BlockNode("html")
    html.block()
    return html
}

fun BlockNode.head(block: BlockNode.() -> Unit): BlockNode {
    val head = BlockNode("head")
    head.block()
    this.children += head
    return head
}

fun BlockNode.body(block: BlockNode.() -> Unit): BlockNode {
    val body = BlockNode("body")
    body.block()
    this.children += body
    return body
}

fun main() {
    val htmlContent = html {
        head {
            "meta" { "charset"("UTF-8") }
        }
        body {
            "h1" {
                "style"("color:red")
                +"Study Kotlin!"
            }
            "div" {
                "style"(
                    """
                    width: 200px; 
                    height: 200px; 
                    line-height: 200px; 
                    background-color: #C9394A;
                    text-align: center
                    """.trimIndent()
                )
                "span" {
                    "style"(
                        """
                        color: white;
                        font-family: Microsoft YaHei
                        """.trimIndent()
                    )
                    +"Hello HTML DSL!!"
                }
            }
        }
    }.render()

    File("Kotlin.html").writeText(htmlContent)
}