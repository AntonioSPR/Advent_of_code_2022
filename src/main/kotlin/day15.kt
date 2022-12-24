// --- Day : 15 ---
//

fun day15(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 15:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day15_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day15Part1(input)
    day15Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day0(){

fun day15Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day15Part1(input: String) {

fun day15Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day15Part2(input: String) {
