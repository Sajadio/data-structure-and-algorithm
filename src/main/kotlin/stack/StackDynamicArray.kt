package stack

import kotlin.collections.ArrayList

class StackDynamicArray<T : Any> {

    private var stack = ArrayList<Any>()
    private var pointer = -1
    var size = 0

    fun push(newItem: T) {
        pointer++
        stack.add(newItem)
        size = stack.size
    }

    fun pop(): Any {
        if (isStackEmpty()) {
            return "The stack is empty"
        }
        val item = stack[pointer]
        removeAt(pointer--)
        return item
    }

    fun peek(): Any {
        return stack[pointer]
    }

    private fun removeAt(index: Int) {
        stack.removeAt(index)
    }

    private fun isStackEmpty(): Boolean {
        return (pointer == -1)
    }
}


fun main() {
    val stack = StackDynamicArray<Int>()

    stack.push(12)
    stack.push(3)
    stack.push(55)
    stack.push(100)
    stack.push(120)

    println(stack.size)

    println(stack.peek())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())

}