// --- Day 22:  ---
//

fun day22(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 22:                       =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day22_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day22Part1(input)
    day22Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day22(){

fun day22Part1(input: String) {
    //
    var text = "--- Part One ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day22Part1(input: String) {

fun day22Part2(input: String) {
    //
    var text = "--- Part Two ---\n"
    text += "${input[0]}\n"
    println(text)

} // ---------------------------------------- fun day22Part2(input: String) {
