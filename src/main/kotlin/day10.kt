// --- Day 10: Cathode-Ray Tube ---

fun day10(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =     Day 10: Cathode-Ray Tube     =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day10_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day10Part1(input)
    day10Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day10(){

fun day10Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day10Part1(input: String) {

fun day10Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day10Part2(input: String) {
