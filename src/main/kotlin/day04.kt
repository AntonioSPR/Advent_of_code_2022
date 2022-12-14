// --- Day 4: Camp Cleanup ---
// Find in how many assignment pairs does one range fully contain the other

fun day04(){

    val title = """
    
        =============================
        =    Advent of code 2022    =
        =    Day 4: Camp Cleanup    =
        =============================
        
       """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day04_input.txt")

    //  Pass the input to the functions that solve the puzzles
    input.day04Part1()
    input.day04Part2()

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // ---------------------------------------- fun day04(){

fun String.day04Part1(){
    // Find in how many assignment pairs does one range fully contain the other

    var totalOfPairsFullyContainedInOthers = 0
    val inputLines = this.lines()

    inputLines.forEach {
        val pair1 = it.split(',')[0]
        val pair2 = it.split(',')[1]
        if (
            (
             (pair1.split("-")[0].toInt() <=  pair2.split("-")[0].toInt()) &&
             (pair1.split("-")[1].toInt() >=  pair2.split("-")[1].toInt())
            ) ||
            (
             (pair1.split("-")[0].toInt() >=  pair2.split("-")[0].toInt()) &&
             (pair1.split("-")[1].toInt() <=  pair2.split("-")[1].toInt())
             )
        ) {
            totalOfPairsFullyContainedInOthers++
        }
    }

    var text = "--- Part One ---\n"
    text += "There are $totalOfPairsFullyContainedInOthers assignment pairs where one range fully contain the other\n"
    println(text)

} // ---------------------------------------- fun day04Part1(inputString: String) {


fun String.day04Part2(){
    // Find the number of pairs that overlap at all

    var totalOfPairsOverlaped = 0
    val inputLines = this.lines()
    inputLines.forEach {
        val pair1 = it.split(',')[0]
        val pair2 = it.split(',')[1]
        val pair1Begin = pair1.split("-")[0].toInt()
        val pair1End = pair1.split("-")[1].toInt()
        val pair2Begin = pair2.split("-")[0].toInt()
        val pair2End = pair2.split("-")[1].toInt()

        if ( pair1Begin in pair2Begin..pair2End ||
             pair1End   in pair2Begin..pair2End ||
             pair2Begin in pair1Begin..pair1End ||
             pair2End   in pair1Begin..pair1End) {
            totalOfPairsOverlaped++
        }
    }

    var text = "--- Part Two ---\n"
    text += "There are $totalOfPairsOverlaped assignment pairs which the ranges overlaped\n"
    println(text)

} // ---------------------------------------- fun day04Part2(inputString: String) {
