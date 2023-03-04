package linked_list

data class Node(val data: Any, var next: Node? = null)

class LinkedList {
    private var head: Node? = null

    fun add(data: Any) {
        val newNode = Node(data, null)
        var current = head

        if (head == null) {
            head = newNode // O(1)
        } else {
            while (current?.next != null) { // O(n)
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun deleteFirstNode() { // O(1)
        head = head?.next
    }

    fun deleteLastNode() {
        if (head == null) {
            return
        } else if (head?.next == null) { // O(1)
            head = null
        } else {
            var current = head
            while (current?.next?.next != null) { // O(n)
                current = current.next
            }
            current?.next = null
        }
    }

    fun deleteSelectedNode(data: Any) {
        var current = head
        var previous: Node? = null

        if (current != null && current.data == data) { // if the data from the first node == data  O(1)
            head = current.next
        }

        while (current?.data != data) { // O(n)
            previous = current
            current = current?.next
        }
        previous?.next = current.next
    }

    fun searchAboutNode(data: Any): Node? {
        var current = head
        return if (current != null && current.data == data) {
            return head
        } else {
            while (current?.data != data) { // O(n)
                current = current?.next
            }
            current
        }
    }

    fun display() {
        var current = head
        while (current != null) {   // O(n)
            print("${current.data} -> ")
            current = current.next
        }
        print("null")
        println()
    }
}

fun main() {
    LinkedList().apply {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
        add(6)
        add(7)
        add(8)
        add(9)
        add(10)
        display()
        deleteFirstNode()
        display()
        deleteLastNode()
        display()
        deleteSelectedNode(3)
        display()
        println(searchAboutNode(2))
    }
}