package hash_table.open_address

import javax.naming.SizeLimitExceededException


/* Open Address: is One way of collision
       *    - Linear probing ✅
       *    - Quadratic probing
       *    - Double Hash
*/
class HashTableLinearProbing<K, V>(private var capacity: Int, private var loadFactor: Float = 0.7f) {
    private var table = Array<Table<K, V>?>(capacity) { null }
    private var size = 0

    private data class Table<K, V>(var key: K, var value: V)

    fun insert(key: K, value: V) { // O(n) because contain findSlot function and this function depend on while loop
        if (size >= capacity * loadFactor) {
            resize(capacity * 2)
        }
        var index = hash(key)
        var i = 0
        while (table[index] != null) {
            index = getLinearProbing(index)
            i++
        }
        table[index] = Table(key,value)
        size++
    }

    fun search(key: K): Any? { // O(n)
        var index = findSlot(key)
        while (table[index] != null && table[index]?.key != key) {
            index = getLinearProbing(index)
        }
        return if (table[index]?.value != null) table[index] else "Not found"
    }

    fun update(key: K, value: V) { // O(1)
        var index = findSlot(key)
        while (table[index] != null && table[index]?.key != key) {
            index = getLinearProbing(index)
        }
        table[index] = Table(key,value)
    }

    fun delete(key: K) { // O(n)
        if (size == 0) {
            throw SizeLimitExceededException("Hash table is empty")
        }
        var index = findSlot(key)
        while (table[index] != null && table[index]?.key != key) {
            index = getLinearProbing(index)
        }
        table[index] = null
        size--
    }

    private fun hash(key: K): Int { // O(1)
        return key.hashCode() % capacity
    }

    private fun findSlot(key: K): Int { // O(n)
        var index = hash(key)
        while (table[index]?.key != null && table[index]?.key != key) {
            index = getLinearProbing(index)
        }
        return index
    }

    private fun getLinearProbing(index: Int): Int {
        return ((index + 1) % capacity)
    }

    private fun resize(newCapacity: Int) {
        val oldKeys = table.map { it?.key }
        val oldValues = table.map { it?.value }
        table = Array(newCapacity) { null }
        capacity = newCapacity
        size = 0
        for (i in oldKeys.indices) {
            if (oldKeys[i] != null) {
                insert(oldKeys[i]!!, oldValues[i]!!)
            }
        }
    }

}

fun main() {
    val hashTable = HashTableLinearProbing<Int, Int>(2)
    try {
        hashTable.apply {

            insert(7, 77)
            insert(36, 366)
            insert(18, 188)
            insert(62, 622)
            insert(3, 33)
            insert(5, 55)

            println(search(7))
            println(search(36))
            println(search(18))
            println(search(62))
            println(search(3))
            println(search(5))

            println("------after delete------\n")

            delete(3)

            println(search(7))
            println(search(36))
            println(search(18))
            println(search(62))
            println(search(3))
            println(search(5))

            println("-------before update------\n")

            println(search(18))
            println(search(3))

            update(18, 881)
            update(3, 333)

            println("-------after update------\n")

            println(search(7))
            println(search(36))
            println(search(18))
            println(search(62))
            println(search(3))
            println(search(5))
        }
    } catch (e: Exception) {
        println(e.message)
    }
}
