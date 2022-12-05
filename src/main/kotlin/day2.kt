import kotlin.system.exitProcess

// --- Day 2: Rock Paper Scissors ---
// What would your total score be if everything goes exactly according to your strategy guide?

fun day02(){
    val title = """
    
        ================================
        =      Advent of code 2022     =
        =  Day 2: Rock Paper Scissors  =
        ================================
        
       """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day02_input.txt")

    //  Pass the input to the functions that solve the puzzles
      day02Part1(input)
//    day01Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // ---------------------------------------- fun day02(){


fun day02Part1(inputString: String) {
    // Find your total score be if everything goes exactly according to your strategy guide

    val rounds = inputString.split("\n")
    val points = mapOf(
        // Rules A,X = Rock , B,Y = Paper, C,Z = Scissors
        // score:
        // Rock(X) = 1 point, Paper(Y) = 2 points, Scissors(Z) = 3 points
        // Wins  6 points -> A Y ; B Z ; C X
        // Draws 3 points -> A X ; B Y ; C Z
        // Loses 0 point ->  A Z ; B X ; C Y
        "A X" to 3 + 1,  // rock rock  // I put the scores as sums for clarity
        "A Y" to 6 + 2,  // rock paper
        "A Z" to 0 + 3,  // rock scissors
        "B X" to 0 + 1,  // paper rock
        "B Y" to 3 + 2,  // paper paper
        "B Z" to 6 + 3,  // paper scissors
        "C X" to 6 + 1,  // scissors rock
        "C Y" to 0 + 2,  // scissors paper
        "C Z" to 3 + 3   // scissors scissors
    )

    var score = 0
    try{
        rounds.forEach{
            score += points[it]!!
        }
    } catch (e: Exception){
        println("There is a problem adding the scores")
        exitProcess(42)
    }

    var text = "--- Part One ---\n"
    text += "If everything goes exactly according to your strategy guide, your score will be $score \n"
    println(text)

} // ---------------------------------------- fun day02Part1(inputString: String) {


fun day02Part2(inputString: String) {
    //
    var text = "--- Part Two ---\n"
//    text += "The elves that carry the most calories son:\n"
//    text += "    The $firstElf${ordinal(firstElf)} carry ${elvesSorted[0]} calories\n"
//    text += "    The $secondElf${ordinal(secondElf)} carry ${elvesSorted[1]} calories\n"
//    text += "    The $thirdElf${ordinal(thirdElf)} carry ${elvesSorted[2]} calories\n"
//    text += "The first three carry $sumThreeMaxCalories calories.\n\n"
    print(text)

} // ---------------------------------------- fun day02Part2(inputString: String) {
