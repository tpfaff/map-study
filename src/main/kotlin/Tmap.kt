class Tmap<T> : Imap<T>, Collection<Pair<String, T>> {

    private val SIZE = 10
    private var list: List<MutableList<Pair<String, T>>> = List(SIZE) { mutableListOf() }

    override fun put(key: String, value: T): Boolean {
        if(list[hash(key)].isEmpty()){
            //if nothing there add it
            println("Adding with no collision fresh key $key and value $value")
            list[hash(key)].add(Pair(key, value))
        } else {
            //if something there, add it to the sublist
            list[hash(key)].let {
                var keyExists = false
                it.forEach { pair ->
                    val existingKey = pair.first
                    if(key == existingKey){
                        keyExists = true
                    }
                }

                if(keyExists){
                    //update the pair in the sublist
                    list[hash(key)].let { sublist ->
                       val removed = sublist.removeIf { pair -> pair.first == key }
                        println("Updating.... removed : $removed")
                        list[hash(key)].add(Pair(key, value))
                        println("Updated with $key and $value")
                    }
                }else{
                    //add key/val to sublist
                    println("Adding fresh key $key and value $value")
                    it.add(Pair(key, value))
                }

            }
        }


        return true
    }

    override fun get(key: String): Any? {
        if(list[hash(key)].size == 1){
            return list[hash(key)][0].second
        } else {
            list[hash(key)].forEach {
                if(it.first == key){
                    return it
                }
            }
        }

        return null
    }

    override fun keys(): List<String> {
        return list.flatten().map { it.first }
    }

    override fun values(): List<T> {
        return list.flatten().map { it.second }
    }

    override fun hash(key: String): Int {
        var value = key.hashCode() % SIZE
        if(value < 0){
            value *= -1
        }
        println("hash of $key is ${key.hashCode()} and modded and normalized is ${value}")

        return value
    }

    override fun contains(element: Pair<String, T>): Boolean {
        return list.flatten().contains(element)
    }

    override fun containsKey(key: String): Boolean {
        return list.flatten().map { it.first }.contains(key)
    }

    override fun containsValue(value: T): Boolean {
        return list.flatten().map { it.second }.contains(value)
    }

    override fun containsAll(elements: Collection<Pair<String, T>>): Boolean {
       elements.forEach {
           if(list.flatten().contains(it).not()) return false
       }
        return true
    }

    override val size: Int
        get() = list.flatten().size

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun iterator(): Iterator<Pair<String, T>> {
        return list.flatten().iterator()
    }
}