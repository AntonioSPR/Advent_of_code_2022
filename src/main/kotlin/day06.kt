import java.util.*

// --- Day 6: Tuning Trouble ---
// Add a subroutine to the device that detects a start-of-packet marker in the datastream.
// The start of a packet is indicated by a sequence of four characters that are all different.
// Part 1: How many characters need to be processed before the first start-of-packet marker is detected?
// A start-of-message marker is just like a start-of-packet marker, except it consists of 14 distinct characters rather than 4
// Part 2: How many characters need to be processed before the first start-of-message marker is detected?
fun day06(){
    val title = """
    
        =============================
        =    Advent of code 2022    =
        =   Day 6: Tuning Trouble   =
        =============================
        
       """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day06_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day06Part1(input)
    day06Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------- fun day06(){

fun day06Part1(input: String) {
    // Add a subroutine to the device that detects a start-of-packet marker in the datastream.
    // The start of a packet is indicated by a sequence of four characters that are all different.
    // Part 1: How many characters need to be processed before the first start-of-packet marker is detected?

    val dataQueueWithList = FixedQueueWithList(4)
    var numberOfCharProcessed : Int

    for (i in 0..3){
        dataQueueWithList.push(input[i])
    }
    if (dataQueueWithList.allItemsDifferent()){
        numberOfCharProcessed = 4
    }
    else {
        numberOfCharProcessed = 0
        for (i in 4 until input.length) {
            dataQueueWithList.push(input[i])
            if (dataQueueWithList.allItemsDifferent()){
                numberOfCharProcessed = i + 1
                println(dataQueueWithList.toString())
                dataQueueWithList.elements.forEach{ print(it) }
                println("")
                break
            }
        }
    }

    var text = "--- Part One ---\n"
    if ( numberOfCharProcessed == 0){
            text += "None start-of-packet marker has been detected"
    }
    else {
        text += "The first start-of-packet marker has been detected after process $numberOfCharProcessed chars"
    }
    println(text)

} // --------------------------- fun day06Part1(input: String) {


fun day06Part2(input: String) {
    // Add a subroutine to the device that detects a start-of-message marker in the datastream.
    // A start-of-message marker is just like a start-of-packet marker, except it consists of 14 distinct characters
    //  How many characters need to be processed before the first start-of-message marker is detected?
    val dataQueueWithList = FixedQueueWithList(14)
    var numberOfCharProcessed : Int

    for (i in 0..13){
        dataQueueWithList.push(input[i])
    }
    if (dataQueueWithList.allItemsDifferent()){
        numberOfCharProcessed = 14
    }
    else {
        numberOfCharProcessed = 0
        for (i in 14 until input.length) {
            dataQueueWithList.push(input[i])
            if (dataQueueWithList.allItemsDifferent()){
                numberOfCharProcessed = i + 1
                println(dataQueueWithList.toString())
                dataQueueWithList.elements.forEach{ print(it) }
                println("")
                break
            }
        }
    }

    var text = "--- Part Two ---\n"
    if ( numberOfCharProcessed == 0){
        text += "None start-of-packet marker has been detected"
    }
    else {
        text += "The first start-of-packet marker has been detected after process $numberOfCharProcessed chars"
    }
    println(text)

} // --------------------------- fun day06Part2(input: String) {

