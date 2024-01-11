fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

//    val myMap = Tmap<String>()
//    myMap.put("first", "first value")
//    myMap.put("second", "second value")
//
//
//   // printOut(myMap)
//
//    myMap.put("first", "a new first value")

   // printOut(myMap)


    val bMap = BinaryMap<String>()
    for (i in 1..50){
        bMap.put("$i", "$i value")
    }

    printOut(null, bMap)

}

fun printOut(map: Tmap<String>?, bMap: BinaryMap<String>){
    map?.let {
    map.forEach{
        println("Printing... ${it.first} : ${it.second}")
    }

    map.keys().forEach{
        println("Printing each key $it")
    }
    }

//    println( bMap.get("first bin"))
//    println( bMap.get("second bin"))
//    println( bMap.get("third bin"))
//    println( bMap.get("four bin"))
//    println( bMap.get("five bin"))
//    println( bMap.get("six bin"))
//    println( bMap.get("seven bin"))
//    println( bMap.get("eight bin"))
//    println( bMap.get("nine bin"))
//    println( bMap.get("ten bin"))
//    println( bMap.get("eleven bin"))
//    println( bMap.get("twelve bin"))


    bMap.printOutTree()


}