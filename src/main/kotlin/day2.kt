import java.io.File
import java.io.InputStream

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

    // First read the input into a string, then solve part 1 and part 2
    try {
        val inputStream: InputStream = File("day02_input.txt").inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }

        day02Part1(inputString)
        day02Part2(inputString)
    }
    catch(E: Exception){
        println("\n --------- Read file error ---------\n")
    }

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // ---------------------------------------- fun day02(){



fun day02Part1(inputString: String) {
    // Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?

    val calories = inputString.replace("\n\n", ";").split(";") // I can't make .split("\n\n")
    val elves = IntArray(calories.size) { 0 }

    for (i in elves.indices) {
        val arrayCalories = calories[i].split("\n")
        arrayCalories.forEach {
            try {
                elves[i] += it.toInt()
            } catch (e: Exception) {
                println("\n--- Wrong data on $i${ordinal(i + 1)} elf out of ${elves.size - 1} (starting to count at one)\n")
            }
        }
    }

    val maxCalories = elves.maxOrNull() ?: 0
    val maxElf = elves.indexOf(maxCalories) + 1

    var text = "--- Part One ---\n"
    text += "The $maxElf${ordinal(maxElf)} elf carry $maxCalories calories  (Starting to count by one)\n"
    println(text)

} // ---------------------------------------- fun day02Part1(inputString: String) {



fun day02Part2(inputString: String) {
    // Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?

    val calories = inputString.replace("\n\n", ";").split(";") // I can't make .split("\n\n")
    val elves = IntArray(calories.size) { 0 }

    for (i in elves.indices) {
        val arrayCalories = calories[i].split("\n")
        arrayCalories.forEach {
            try {
                elves[i] += it.toInt()
            } catch (e: Exception) {
                println("\n--- Wrong data on $i${ordinal(i + 1)} elf out of ${elves.size - 1} (starting to count at one)\n")
            }
        }
    }

    val elvesSorted = elves.sortedDescending()
    val sumThreeMaxCalories = elvesSorted[0] + elvesSorted[1] + elvesSorted[2]
    val firstElf = elves.indexOf(elvesSorted[0])
    val secondElf = elves.indexOf(elvesSorted[1])
    val thirdElf = elves.indexOf(elvesSorted[2])

    var text = "--- Part Two ---\n"
    text += "The elves that carry the most calories son:\n"
    text += "    The $firstElf${ordinal(firstElf)} carry ${elvesSorted[0]} calories\n"
    text += "    The $secondElf${ordinal(secondElf)} carry ${elvesSorted[1]} calories\n"
    text += "    The $thirdElf${ordinal(thirdElf)} carry ${elvesSorted[2]} calories\n"
    text += "The first three carry $sumThreeMaxCalories calories.\n\n"
    print(text)

} // ---------------------------------------- fun day02Part2(inputString: String) {










