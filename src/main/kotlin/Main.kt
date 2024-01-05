fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val myMap = Tmap<String>()
    myMap.put("first", "first value")
    myMap.put("second", "second value")


   // printOut(myMap)

    myMap.put("first", "a new first value")

   // printOut(myMap)


    val bMap = BinaryMap<String>()
    bMap.put("first bin", "first bin value")
    bMap.put("second bin", "second bin value")
    bMap.put("third bin", "third bin value")
    bMap.put("four bin", "four bin value")
    bMap.put("five bin", "five bin value")
    bMap.put("six bin", "six bin value")
    bMap.put("seven bin", "seven bin value")
    bMap.put("eight bin", "eight bin value")
    bMap.put("nine bin", "nine bin value")
    bMap.put("ten bin", "ten bin value")
    bMap.put("eleven bin", "eleven bin value")
    bMap.put("twelve bin", "twelve bin value")

    printOut(myMap, bMap)

}

fun printOut(map: Tmap<String>, bMap: BinaryMap<String>){
    map.forEach{
        println("Printing... ${it.first} : ${it.second}")
    }

    map.keys().forEach{
        println("Printing each key $it")
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