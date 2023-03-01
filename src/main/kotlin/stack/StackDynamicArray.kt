package stack

class StackDynamicArray<T : Any> {

    private var stackDynamicArray = ArrayList<Any>()
    private var pointer = -1
    var size = 0

    fun push(newItem: T) {
        pointer++
        stackDynamicArray.add(newItem)
        size = stackDynamicArray.size
    }

    fun pop(): Any {
        if (isStackEmpty()) {
            return "The stack is empty"
        }
        val item = stackDynamicArray[pointer]
        removeAt(pointer--)
        return item
    }

    fun peek(): Any {
        return stackDynamicArray[pointer]
    }

    private fun removeAt(index: Int) {
        stackDynamicArray.removeAt(index)
    }

    private fun isStackEmpty(): Boolean {
        return (pointer == -1)
    }
}


fun main() {
    val stackDynamicArray = StackDynamicArray<Int>()

    stackDynamicArray.push(12)
    stackDynamicArray.push(3)
    stackDynamicArray.push(55)
    stackDynamicArray.push(100)
    stackDynamicArray.push(120)

    println(stackDynamicArray.size)

    println(stackDynamicArray.peek())
    println(stackDynamicArray.pop())
    println(stackDynamicArray.pop())
    println(stackDynamicArray.pop())
    println(stackDynamicArray.pop())
    println(stackDynamicArray.pop())
    println(stackDynamicArray.pop())
    println(stackDynamicArray.pop())

}