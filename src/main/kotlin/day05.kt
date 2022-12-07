// --- Day 5: Supply Stacks ---
// Find what crate ends up on top of each stack

fun day05(){

    val title = """
    
        =============================
        =    Advent of code 2022    =
        =    Day 5: Supply Stacks    =
        =============================
        
       """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day05_input.txt")

    //  Pass the input to the functions that solve the puzzles
    input.day05Part1()
    // input.day05Part2()

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // ---------------------------------------- fun day04(){

fun String.day05Part1(){
    // Find in how many assignment pairs does one range fully contain the other

    var totalOfPairsFullyContainedInOthers = 0
    val inputLines = this.lines()

    var i = 0
    inputLines.forEach {
        val pair_1 = it.split(',')[0]
        val pair_2 = it.split(',')[1]
        if (
            (
                    (pair_1.split("-")[0].toInt() <=  pair_2.split("-")[0].toInt()) &&
                            (pair_1.split("-")[1].toInt() >=  pair_2.split("-")[1].toInt())
                    ) ||
            (
                    (pair_1.split("-")[0].toInt() >=  pair_2.split("-")[0].toInt()) &&
                            (pair_1.split("-")[1].toInt() <=  pair_2.split("-")[1].toInt())
                    )
        ) {
            totalOfPairsFullyContainedInOthers++
        }
    }

    var text = "--- Part One ---\n"
    text += "There are $totalOfPairsFullyContainedInOthers assignment pairs where one range fully contain the other\n"
    println(text)

} // ---------------------------------------- fun day05Part1(inputString: String) {


fun String.day05Part2(){
    // Part 2
    var text = "--- Part Two  ---\n"
    text += "There are  assignment pairs which the ranges overlaped\n"
    println(text)

} // ---------------------------------------- fun day05Part2(inputString: String) {
