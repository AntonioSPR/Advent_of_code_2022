// Day 3: Rucksack Reorganization
// Find sum of the priorities of items that appears in both compartments of each rucksack

fun day03(){
    val title = """
    
        ====================================
        =      Advent  of  code  2022      =
        =  Day 3: Rucksack Reorganization  =
        ====================================
        
       """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day03_input.txt")

    //  Pass the input to the functions that solve the puzzles
    input.day03Part1()
    input.day03Part2()

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // ---------------------------------------- fun day03(){


fun String.day03Part1() {
    // Find sum of the priorities of items that appears in both compartments of each rucksack

    // Lowercase item types a through z have priorities  1 through 26 --> .code - 96
    // Uppercase item types A through Z have priorities 27 through 52 --> .code - 38

    // 'A'.code ->  65
    // 'Z'.code ->  90
    // 'a'.code ->  97
    // 'z'.code -> 122

    //    for (c in 'a'..'z'){
    //        println("The ascii code of $c is ${c.code}")
    //    }
    //    for (c in 'A'..'Z'){
    //        println("The ascii code of $c is ${c.code}")
    //    }

    // ****************************** Let's make a test ******************************
    // String.substring(startIndex: Int, endIndex: Int): String
    //    var myString = "1234567890."
    //    println (
    //        "myString begins in " +
    //        myString.substring(0,myString.length / 2) +
    //        " and ends in " +
    //        myString.substring(myString.length / 2, myString.length)
    //    )
    // ************************************ done *************************************

    var totalPriority = 0
    val inputLines = this.lines()

    inputLines.forEach{
        val begin = it.substring(0, it.length / 2)
        val end = it.substring(it.length / 2, it.length)
        val letter: Char = repeatedChar(begin, end)

        if (letter in 'a'..'z') {
            totalPriority += letter.code - 96
        }
        else if (letter in 'A'..'Z') {
            totalPriority += letter.code - 38
        }
        else {
            println("\n --------- Input data error -> line $it ---------\n")
            kotlin.system.exitProcess(37)
        }
    }

    var text = "--- Part One ---\n"
    text += "The total priority of the items that appears in both compartments of each rucksack is $totalPriority"
    println(text)

} // ---------------------------------------- fun day03Part1(inputString: String) {

fun repeatedChar(s1: String, s2: String): Char {
    for (c1 in s1.toCharArray()) {
        for(c2 in s2.toCharArray()){
            if (c1 == c2 ){
                return c1
            }
        }
    }
    println("\n --------- Input data error -> The line $s1$s2 has not repeated chars ---------\n")
    kotlin.system.exitProcess(37)
}

fun String.day03Part2() {
    // Lowercase item types a through z have priorities  1 through 26
    // Uppercase item types A through Z have priorities 27 through 52

    // 'A'.code ->  65
    // 'Z'.code ->  90
    // 'a'.code ->  97
    // 'z'.code -> 122

    //    for (c in 'a'..'z'){
    //        println("The ascii code of $c is ${c.code}")
    //    }
    //    for (c in 'A'..'Z'){
    //        println("The ascii code of $c is ${c.code}")
    //    }

    var text = "--- Part Two ---\n"
    text += this.substring(0,1)
    println(text)

} // ---------------------------------------- fun day01Part1(inputString: String) {
