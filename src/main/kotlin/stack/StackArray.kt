package stack

class StackArray<T : Any>(size: Int) {

    private var stackArray = Array<Any>(size) { it }
    private var pointer: Int = -1
    val size = stackArray.size

    fun push(newItem: T): String {
        if (!isStackFull()) {
            pointer++
            stackArray[pointer] = newItem
        }
        return "Can't push this ($newItem) item because the stack is full"
    }

    fun pop(): Any {
        val item: Any
        if (isStackEmpty()) {
            return "the stack is empty"
        } else {
            item = stackArray[pointer]
            pointer--
        }
        return item
    }

    fun peek(): Any {
        return if (isStackEmpty()) {
            "There's nothing to peek because"
        } else
            stackArray[pointer]
    }

    private fun isStackFull(): Boolean {
        return (pointer == size - 1)
    }

    private fun isStackEmpty(): Boolean {
        return (pointer == -1)
    }
}

fun main() {
    val stackArray = StackArray<Int>(2)
    stackArray.push(12)
    stackArray.push(3)
    println(stackArray.push(55))
    println(" ${stackArray.peek()}")
    println(" ${stackArray.pop()}")
    println(" ${stackArray.peek()}")
    println(" ${stackArray.pop()}")
    println(" ${stackArray.peek()}")
    println(" ${stackArray.pop()}")

    println(stackArray.size)
}