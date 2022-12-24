// --- Day 18:  ---
//

fun day18(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 18:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day18_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day18Part1(input)
    day18Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day18(){

fun day18Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day18Part1(input: String) {

fun day18Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day18Part2(input: String) {
