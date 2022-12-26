// --- Day 10: Cathode-Ray Tube ---
// addx V takes two cycles to complete. After two cycles, the X register is increased by the value V. (V can be negative.)
// noop takes one cycle to complete. It has no other effect.
// Signal strength is the cycle number multiplied by the value of the X register
// Part 1: Find the sum of signal strength during the 20th, 60th, 100th, 140th, 180th, and 220th cycles.
// your answer is too low 13300 13100 14340
// Part 2: What eight capital letters appear on your CRT?

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
            println("addx*$number*")
            register.addX(number)
        }
        else { // line is noop
            println("noop")
            register.noOp()
        }
    }

    var sumOfStrengths = 0
    for (i in arrayOf(20, 60, 100, 140, 180, 220)){
        sumOfStrengths += register.mapOfStrengths[i]!!
    }

    var text = "--- Part One ---\n"
    text += "The sum of signal strength during the 20th, 60th, 100th, 140th, 180th, and 220th cycles is: $sumOfStrengths"
    println(text)

} // ---------------------------------------- fun day10Part1(input: String) {


fun day10Part2(input: String) {
    // Part 2 What eight capital letters appear on your CRT?
    var text = "--- Part Two ---"
    text += "${input[0]}\n"

    println(text)

} // ---------------------------------------- fun day10Part2(input: String) {


class Clock (time: Int = 0){
    var time : Int = time
        private set

    fun tick(cycles: Int = 1){
        check(cycles >= 1){"Error: Class Clock -> are you traveling faster than light?"}
        time += cycles
    }

    override fun toString(): String {
        val hours: Int = time / 3600
        val minutes : Int = (time - hours * 3600) / 60
        val seconds : Int = time - hours * 3600 - minutes * 60
        return "${String.format("%02d", hours)}:${String.format("%02d", minutes)}:${String.format("%02d", seconds)}"
    } // ---------------------------------------- override fun toString(): String {

} // ---------------------------------------- class clock (time: Int = 0){


class Register(private var value: Int = 1){
    private var clock = Clock()
    val mapOfStrengths = mutableMapOf(0 to 0)

    fun noOp (){
        tick()
        println("---------------------------------------- Dentro de noOp. value:$value --- time:${clock.time}")
    } // ---------------------------------------- fun noOp (){

    fun addX(n: Int = 0){
        tick(2)
        this.value += n
        println("---------------------------------------- Dentro de addX. value:$value --- time:${clock.time}")
    } // ---------------------------------------- fun addX(n: Int = 0){

    private fun tick(cycles: Int = 1){
        check(cycles >= 1){"Error: Class Clock -> are you traveling faster than light?"}
        for (t in 1..cycles){
            clock.tick()
            mapOfStrengths[clock.time] = this.value * this.clock.time
            println(
                "  --- Cycle:"  + String.format("% 2d", clock.time) +
                        "  ---  Value:" + String.format("% 2d", value) +
                        "  ---  Strength signal:" + String.format("% 2d", mapOfStrengths[clock.time]) +
                        " --- "
            )
        }
    }

} // ---------------------------------------- class Register(x: Int = 0){
