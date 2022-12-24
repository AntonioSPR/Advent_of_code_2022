// --- Day 24:  ---
//

fun day24(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 24:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day24_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day24Part1(input)
    day24Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day25(){

fun day24Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day24Part1(input: String) {

fun day24Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day24Part2(input: String) {
