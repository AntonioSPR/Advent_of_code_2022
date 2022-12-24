// --- Day : 14 ---
//

fun day14(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 14:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day14_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day14Part1(input)
    day14Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day0(){

fun day14Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day14Part1(input: String) {

fun day14Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day14Part2(input: String) {
