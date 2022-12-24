// --- Day 21:  ---
//

fun day21(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 21:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day21_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day21Part1(input)
    day21Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day21(){

fun day21Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day21Part1(input: String) {

fun day21Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day21Part2(input: String) {
