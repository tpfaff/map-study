fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val myMap = Tmap<String>()
    myMap.put("first", "first value")
    myMap.put("second", "second value")


    printOut(myMap)

    myMap.put("first", "a new first value")

    printOut(myMap)
}

fun printOut(map: Tmap<String>){
    map.forEach{
        println("Printing... ${it.first} : ${it.second}")
    }

    map.keys().forEach{
        println("Printing each key $it")
    }
}