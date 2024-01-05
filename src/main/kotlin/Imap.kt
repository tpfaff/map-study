interface Imap<T> {
    fun put(key: String, value: T): Boolean
    fun get(key: String): Any?
    fun keys(): List<String>
    fun values(): List<T>
    fun hash(key: String): Int
    fun containsKey(key: String): Boolean
    fun containsValue(value: T): Boolean
}