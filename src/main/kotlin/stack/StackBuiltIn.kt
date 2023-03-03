package stack

import java.util.*

fun main() {

    // built-in
    val stack = Stack<Int>()

    //push == add
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    //pop == get and the same time remove it from stack
    stack.pop()
    stack.pop()

    //peek == read
    stack.peek()
}