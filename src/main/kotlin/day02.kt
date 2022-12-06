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
      day02Part2(input)

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
        // New rules!
        // A = Rock; B = Paper; C = Scissors
        // X means you need to lose,
        // Y means you need to end the round in a draw, and
        // Z means you need to win.
        // Score:
        // Rock = 1 point, Paper = 2 points, Scissors = 3 points
        // Wins  6 points, Draws 3 points, Loses 0 point
        // So the points are:
        //  A X -> A C -> 0 + 3  // rock scissors
        //  A Y -> A A -> 3 + 1  // rock rock
        //  A Z -> A B -> 6 + 2  // rock paper
        //  B X -> B A -> 0 + 1  // paper rock
        //  B Y -> B B -> 3 + 2  // paper paper
        //  B Z -> B C -> 6 + 3  // paper scissors
        //  C X -> C B -> 0 + 2  // scissors paper
        //  C Y -> C C -> 3 + 3  // scissors scissors
        //  C Z -> C A -> 6 + 1  // scissors rock
    val rounds = inputString.split("\n")
    val points = mapOf(
        "A X" to  0 + 3,  // rock scissors
        "A Y" to  3 + 1,  // rock rock
        "A Z" to  6 + 2,  // rock paper
        "B X" to  0 + 1,  // paper rock
        "B Y" to  3 + 2,  // paper paper
        "B Z" to  6 + 3,  // paper scissors
        "C X" to  0 + 2,  // scissors paper
        "C Y" to  3 + 3,  // scissors scissors
        "C Z" to  6 + 1   // scissors rock
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

    var text = "--- Part Two ---\n"
    text += "If everything goes exactly according to your NEW strategy guide, your score will be $score\n"
    println(text)

} // ---------------------------------------- fun day02Part2(inputString: String) {
