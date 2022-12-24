// --- Day : 16 ---
//

fun day16(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 16:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day16_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day16Part1(input)
    day16Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day0(){

fun day16Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day16Part1(input: String) {

fun day16Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day16Part2(input: String) {
