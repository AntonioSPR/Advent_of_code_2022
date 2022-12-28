// --- Day 10: Cathode-Ray Tube ---
// addx V takes two cycles to complete. After two cycles, the X register is increased by the x V. (V can be negative.)
// noop takes one cycle to complete. It has no other effect.
// Signal strength is the cycle number multiplied by the x of the X register
// Part 1: Find the sum of signal strength during the 20th, 60th, 100th, 140th, 180th, and 220th cycles.
// your answer is too low 13300 13100 14340
// Part 2: What eight capital letters appear on your CRT?
// PAPJCBHP

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
    // Part 1: Find the sum of signal strength during the 20th, 60th, 100th, 140th, 180th, and 220th cycles.
    val register = Register()
    val inputLines = input.lines()

    inputLines.forEach{ line ->
        if (line[0] == 'a') { // line is addx n
            val number = line.split(' ')[1].toInt()
            register.addX(number)
        }
        else // line is noop
            register.noOp()
    }
    var sumOfStrengths = 0
    var sumOfStrengths2 = 0
    for (i in arrayOf(20, 60, 100, 140, 180, 220)){
        sumOfStrengths += register.listOfX[i] * (i) // register.x * register.clock.time
      }

    var text = "--- Part One ---\n"
    text += "The sum of signal strength during the 20th, 60th, 100th, 140th, 180th, and 220th cycles is: $sumOfStrengths"
    println(text)

} // ---------------------------------------- fun day10Part1(input: String) {


fun day10Part2(input: String) {
    // Part 2 What eight capital letters appear on your CRT?
    val register = Register()
    val inputLines = input.lines()
    val screen = Array(6){ CharArray(40){'.'} }

    //val prueba = Array
    inputLines.forEach{ line ->
        if (line[0] == 'a') { // line is addx n
            val number = line.split(' ')[1].toInt()
            register.addX(number)
            println(line + " --- time:" + register.clock.time + " --- x:" +  register.listOfX[ register.clock.time - 1])
        }
        else // line is noop
            register.noOp()
    }

    for(time in 1..240){ // register.listOfX.indices==(0..240)
        val line = (time-1) / 40  // time in 1..40 -> line = 0 ; time in 40..79 -> line = 1 ...
        val column: Int = (time-1) % 40 // time == 40 -> column = 0 ; time == 41 -> column = 1 ...
        val x = register.listOfX[time]
        val sprite = (x-1)..(x+1)
        if (column in sprite)
            screen[line][column] = '#'
    }

    val text = "--- Part Two ---\n" +
            "Now the screen is:\n" +
            screen.joinToString("") { it.joinToString("") + "\n" }
    println(text)

} // ---------------------------------------- fun day10Part2(input: String) {


class Clock (time: Int = 0){
    var time : Int = time
        private set

    fun tick(cycles: Int = 1){
        time += cycles
    }

    override fun toString(): String {
        val hours: Int = time / 3600
        val minutes : Int = (time - hours * 3600) / 60
        val seconds : Int = time - hours * 3600 - minutes * 60
        return "${String.format("%02d", hours)}:${String.format("%02d", minutes)}:${String.format("%02d", seconds)}"
    } // ---------------------------------------- override fun toString(): String {

} // ---------------------------------------- class clock (time: Int = 0){


class Register(private var x: Int = 1){
     var clock = Clock()
    val listOfX = mutableListOf(1)  // Item 0 = 1. listOfX[time]==listOfX[i] i in listOfX.indices

    fun noOp (){
        tick()
    } // ---------------------------------------- fun noOp (){

    fun addX(n: Int = 0){
        tick(2)
        this.x += n
    } // ---------------------------------------- fun addX(n: Int = 0){

    private fun tick(cycles: Int = 1){
        for (t in 1..cycles){
            clock.tick()
            listOfX.add(this.x)
        }
    }

} // ---------------------------------------- class Register(x: Int = 0){
