package hash_table

class HashTableWithReplacement<K, V>(size: Int) {
    private val table = Array<Table<K, V>?>(size) { null }

    data class Table<K, V>(var key: K, var value: V)

    private fun hash(key: K): Int { // O(1)
        return key.hashCode() % table.size
    }

    fun insert(key: K, value: V) { // O(1)
        val index = hash(key)
        table[index] = Table(key, value)
    }

    fun update(key: K, value: V) { // O(1)
        val index = hash(key)
        if (table[index]?.key == key) {
            table[index]?.value = value
        }
    }

    fun search(key: K): Any? { // O(1)
        val index = hash(key)
        if (table[index]?.key == key) {
            return table[index]
        }
        return "Not found"
    }

    fun delete(key: K) { // O(1)
        val index = hash(key)
        if (table[index]?.key == key) {
            table[index] = null
        }
    }
}

fun main() {
    val hashTableWithReplacement = HashTableWithReplacement<Int, Int>(5)
    hashTableWithReplacement.insert(1, 100)
    hashTableWithReplacement.insert(2, 200)
    hashTableWithReplacement.insert(3, 300)
    hashTableWithReplacement.insert(4, 400)
    hashTableWithReplacement.insert(5, 500)

    println(hashTableWithReplacement.search(5))
    println(hashTableWithReplacement.search(2))
    hashTableWithReplacement.delete(2)
    println(hashTableWithReplacement.search(2))

    // Replacement: is One way of collision
    println(hashTableWithReplacement.search(4))
    hashTableWithReplacement.update(4, 4500)
    println(hashTableWithReplacement.search(4))

}
