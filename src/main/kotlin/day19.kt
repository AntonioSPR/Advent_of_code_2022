// --- Day 19:  ---
//

fun day19(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 9:                         =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day0_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day19Part1(input)
    day19Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day19(){

fun day19Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day19Part1(input: String) {

fun day19Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day19Part2(input: String) {
