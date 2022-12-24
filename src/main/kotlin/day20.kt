// --- Day 20:  ---
//

fun day20(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 20:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day20_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day20Part1(input)
    day20Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day23(){

fun day20Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day20Part1(input: String) {

fun day20Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day20Part2(input: String) {
