class BinaryMap<T>: Imap<T>, Collection<Pair<String, T>> {

    val SIZE = 10
    private var bList = arrayOfNulls<BinaryTree<T>>(SIZE)

    override fun put(key: String, value: T): Boolean {
        if(bList[hash(key)] == null){
            bList[hash(key)]= BinaryTree(Node(key, value, null, null))
        } else {
            insertNode(root = bList[hash(key)]?.root, Node(key,value,null,null))
        }

        return true
    }

    override fun get(key: String): Any? {
        val hash = hash(key)
        val tree: BinaryTree<T> = bList[hash] ?: return null
        return search(hash, tree)
    }

    override fun keys(): List<String> {
        TODO("Not yet implemented")
    }

    override fun values(): List<T> {
        TODO("Not yet implemented")
    }

    override fun hash(key: String): Int {
        var value = key.hashCode() % SIZE
        if(value < 0){
            value *= -1
        }
       // println("hash of $key is ${key.hashCode()} and modded and normalized is ${value}")

        return value
    }

    fun uniqueHash(key: String): Int{
        return key.hashCode()
//        var hash = key.hashCode()
//        if(hash < 0)
//            hash *= -1
//
//        return hash
    }

    override fun containsKey(key: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: T): Boolean {
        TODO("Not yet implemented")
    }




    private fun insertNode(root: Node<T>?, child: Node<T>){
        println("insertNode")
        var mutableRoot = root
        if(mutableRoot == null){
            mutableRoot = child
            println("set mutableRoot to child")
            return
        }

        var hashedChildKey = uniqueHash(child.key)
      //  println("hashedChildKey is $hashedChildKey")
        if(hashedChildKey < hash(mutableRoot.key)){
            println("going left")
            insertNode(mutableRoot.left, child)
        }
        if(hashedChildKey > hash(mutableRoot.key)){
            println("going right")
            insertNode(mutableRoot.right, child)
        }
    }

//    fun findNode(key: String): Node<T>? {
//
//    }

    fun printOutTree(){
        bList.forEach {
            printBinaryTree(it?.root)
        }
    }

    // Define a function to print a binary tree node and its children recursively
    fun printBinaryTree(node: Node<T>?, level: Int = 0) {
        // Print the node value with indentation based on the level
        println("level is $level")
        println("X".repeat(level * 4) + node?.value)
        // Print the left node with increased level if it is not null
        node?.left?.let { printBinaryTree(it, level + 1) }
        // Print the right node with increased level if it is not null
        node?.right?.let { printBinaryTree(it, level + 1) }
    }
    private fun search(targetHash: Int, tree: BinaryTree<T>): Node<T>?{
        var root = tree.root
        while(root != null){
            if(hash(root.key) == targetHash){
                return root
            }
            if(targetHash < hash(root.key)){
                root = root.left
                continue
            }
            if(targetHash > hash(root.key)){
                root = root.right
            }
        }

        return null
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Pair<String, T>> {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Pair<String, T>>): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: Pair<String, T>): Boolean {
        TODO("Not yet implemented")
    }
}