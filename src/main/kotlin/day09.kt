import kotlin.math.absoluteValue

// --- Day 9: Rope Bridge ---
// Part 1: Find How many positions does the tail of the rope visit at least once
// Part 2: Larger rope with ten knots. How many positions does the tail of the rope visit at least once?

fun day09(){
    val title = """
        
        ===========================
        =   Advent of code 2022   =
        =    Day 9: Rope Bridge   =
        ===========================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day09_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day09Part1(input)
    day09Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day09(){

fun day09Part1(input: String) {
    // Part 1: Find How many positions does the tail of the rope visit at least once
    // your answer is too low 1999 1674 5961
    val rope = Rope()
    val tailPositions = mutableSetOf("(0,0)")
    val inputLines = input.lines()

    inputLines.forEach{
        val direction = it.split(' ')[0]
        val distance = it.split(' ')[1].toInt()
        for (i in 1..distance) {
            when(direction) {
                "U" -> rope.moveUp()
                "L" -> rope.moveLeft()
                "D" -> rope.moveDown()
                "R" -> rope.moveRight()
            }
            tailPositions.add(rope.tail.toString())
        }
    }

    var text = "--- Part One ---\n"
    text += "Now the rope is in $rope and the tail has visit ${tailPositions.size} positions\n"
    println(text)

} // ---------------------------------------- fun day09Part1(input: String) {

fun day09Part2(input: String) {
    // Part 2: Larger rope with ten knots. How many positions does the tail of the rope visit at least once?
    // 2193 Your answer is too low. 2280 2471

    val longRope = LongRope()
    val tailPositions = mutableSetOf("(0,0)")
    val inputLines = input.lines()

    inputLines.forEach{
        val direction = it.split(' ')[0]
        val distance = it.split(' ')[1].toInt()
        println("\n$direction $distance" )
        for (i in 1..distance) {
            when(direction) {
                "U" -> longRope.moveUp()
                "L" -> longRope.moveLeft()
                "D" -> longRope.moveDown()
                "R" -> longRope.moveRight()
            }
            println("\t$longRope")
            tailPositions.add(longRope.tail.toString())
        }
        println("\n ${tailPositions.size} $tailPositions")
    }

    var text = "--- Part Two ---\n"
    text += "Now the rope is in $longRope and the tail has visit ${tailPositions.size} positions\n"
    println(text)
} // ---------------------------------------- fun day09Part2(input: String) {

class Point(var x: Int = 0, var y: Int = 0){
    override fun toString(): String {
        return "($x,$y)"
    }
} // ---------------------------------------- class Point(var x: Int = 0, var y: Int = 0){

class Rope(var head : Point = Point(0,0), var tail : Point = Point(0,0)){

    fun moveUp(){
        head.y++
        moveTheTail()
    }
    fun moveRight(){
        head.x++
        moveTheTail()
    }
    fun moveDown(){
        head.y--
        moveTheTail()
    }
    fun moveLeft(){
        head.x--
        moveTheTail()
    }
    private fun moveTheTail(){
        when (head.x - tail.x) {
            2 -> {
                tail.x++
                tail.y = head.y
            }
            -2 -> {
                tail.x--
                tail.y = head.y

            }
        }
        when (head.y - tail.y) {
             2 -> {
                 tail.y++
                 tail.x = head.x

             }
            -2 -> {
                tail.y--
                tail.x = head.x
            }
        }
    }
    override fun toString(): String {
        return "[$head,$tail]"
    }

} // ---------- class Rope(var head : Point = Point(0,0), var tail : Point  = Point(0,0)){

class LongRope(val body: Array<Point> = Array(10){ Point(0, 0) } ) {

    var head: Point = body[0]
        get() {
            field = body[0]
            return field
        }
        private set

    var tail: Point = body[9]
        get() {
            field = body[9]
            return field
        }
        private set

    fun moveUp(){
        head.y++
        moveThatBody()
    }
    fun moveRight(){
        head.x++
        moveThatBody()
    }
    fun moveDown(){
        head.y--
        moveThatBody()
    }
    fun moveLeft(){
        head.x--
        moveThatBody()
    }

    private fun moveThatBody(){
        for(i in 0 until (body.size - 1) ) {
            val firstKnot = body[i]
            val secondKnot = body[i+1]
            when(firstKnot.x - secondKnot.x){
                2 -> {
                    secondKnot.x++
                    when (firstKnot.y - secondKnot.y) {
                        -2 -> secondKnot.y--
                        -1 -> secondKnot.y--
                        0 ->  print("")
                        1 ->  secondKnot.y++
                        2 ->  secondKnot.y++
                        else -> println("Error: fun moveThatBody() ΔX=2 ")
                    }
                }
                1 -> { // (firstKnot.x - secondKnot.x) == 1
                    when (firstKnot.y - secondKnot.y) {
                        -2 -> {
                            secondKnot.x++
                            secondKnot.y--
                        }
                        -1 -> print("")
                        0 ->  print("")
                        1 ->  print("")
                        2 -> {
                            secondKnot.x++
                            secondKnot.y++
                        }
                        else -> println("Error: fun moveThatBody() ΔX=1")
                    }
                }
                0 ->  when (firstKnot.y - secondKnot.y) {
                    -2 -> secondKnot.y--
                    -1 -> print("")
                    0  -> print("")
                    1  -> print("")
                    2  -> secondKnot.y++
                    else -> println("Error: fun moveThatBody() ΔX=0")
                }
                -1 -> {
                    when (firstKnot.y - secondKnot.y)  {
                        -2 -> {
                            secondKnot.x--
                            secondKnot.y--
                        }
                        -1 -> print("")
                        0 ->  print("")
                        1 ->  print("")
                        2 -> {
                            secondKnot.x--
                            secondKnot.y++
                        }
                        else -> println("Error: fun moveThatBody() ΔX=-1")
                    }
                }
                -2 -> {
                    secondKnot.x--
                    when (firstKnot.y - secondKnot.y) {
                        -2 -> secondKnot.y--
                        -1 -> secondKnot.y--
                        0 ->  print("")
                        1 ->  secondKnot.y++
                        2 ->  secondKnot.y++
                        else -> println("Error: fun moveThatBody() ΔX=-2")
                    }
                }
                else -> {
                    println("Error: fun moveThatBody() ΔX !in (-2..2)")
                }
            } // ---------- when(firstKnot.x - secondKnot.x){
        } // ---------- for(i in 0 until (body.size - 1) ) {
    } // ---------- private fun moveThatBody(){

    override fun toString(): String {
        return "[${body.joinToString(", ")}]"
    } // ---------- override fun toString(): String {

} // ---------- class Rope(var head : Point = Point(0,0), var tail : Point  = Point(0,0)){

//    private fun moveThatBody(){ // V1
//        for(i in 0 until (body.size - 1) ) {
//            val firstKnot = body[i]
//            val secondKnot = body[i+1]
//            // Diagonal movements
//            if ((firstKnot.x - secondKnot.x).absoluteValue == 2 && (firstKnot.y - secondKnot.y).absoluteValue == 2 ){
//                when (firstKnot.x - secondKnot.x) {
//                    2 -> {
//                        secondKnot.x++
//                        secondKnot.y++
//                    }
//                    -2 -> {
//                        secondKnot.x--
//                        secondKnot.y--
//                    }
//                }
//            }
//            else {// NO diagonal movements
//                when (firstKnot.x - secondKnot.x) {
//                    2 -> {
//                        secondKnot.x++
//                        secondKnot.y = firstKnot.y
//                    }
//                    -2 -> {
//                        secondKnot.x--
//                        secondKnot.y = firstKnot.y
//                    }
//                }
//                when (firstKnot.y - secondKnot.y) {
//                    2 -> {
//                        secondKnot.y++
//                        secondKnot.x = firstKnot.x
//                    }
//                    -2 -> {
//                        secondKnot.y--
//                        secondKnot.x = firstKnot.x
//                    }
//                }
//            }
//        }
//    } // ---------- private fun moveThatBody(){


//private fun moveThatBody(){  // V2
//    for(i in 0 until (body.size - 1) ) {
//        val firstKnot = body[i]
//        val secondKnot = body[i+1]
//
//        if((firstKnot.x - secondKnot.x) == 0 || (firstKnot.y - secondKnot.y).absoluteValue == 0 ){
//            // firstKnot and secondKnot in the same line
//            if ((firstKnot.x - secondKnot.x) == 2)
//                secondKnot.x++
//            else
//                if ((firstKnot.x - secondKnot.x) == -2)
//                    secondKnot.x--
//                else
//                    if ((firstKnot.y - secondKnot.y) == 2)
//                        secondKnot.y++
//                    else
//                        if ((firstKnot.y - secondKnot.y) == -2)
//                            secondKnot.y--
//                        else
//                            println("Error linea 193")
//        }
//        else
//            if ((firstKnot.x - secondKnot.x) == 2 && (firstKnot.y - secondKnot.y).absoluteValue == 2 ){
//                // firstKnot and secondKnot in diagonal, 2 squares apart
//                if ((firstKnot.x - secondKnot.x) == 2)
//                    if ((firstKnot.y - secondKnot.y) == 2){
//                        secondKnot.x++
//                        secondKnot.y++
//                    }
//                    else {
//                        secondKnot.x++
//                        secondKnot.y--
//                    }
//                else // firstKnot.x - secondKnot.x) == -2
//                    if ((firstKnot.y - secondKnot.y) == 2){
//                        secondKnot.x--
//                        secondKnot.y++
//                    }
//                    else {
//                        secondKnot.x--
//                        secondKnot.y--
//                    }
//            }
//            else
//                if ((firstKnot.x - secondKnot.x) == 1 || (firstKnot.y - secondKnot.y).absoluteValue == 1 ){
//                    // firstKnot and secondKnot are in a knight hop
//                    if((firstKnot.x - secondKnot.x) == 2){
//                        secondKnot.x++
//                        secondKnot.y = firstKnot.y
//                    }
//                    else
//                        if ((firstKnot.x - secondKnot.x) == -2 ){
//                            secondKnot.x--
//                            secondKnot.y = firstKnot.y
//                        }
//                        else
//                            if((firstKnot.y - secondKnot.y) == 2){
//                                secondKnot.y++
//                                secondKnot.x = firstKnot.x
//                            }
//                            else
//                                if ((firstKnot.y - secondKnot.y) == -2 ){
//                                    secondKnot.y--
//                                    secondKnot.x = firstKnot.x
//                                }
//                                else
//                                    println("Error linea 240")
//                }
//                else
//                    println("Error linea 243")
//
//    } // ---------- for(i in 0 until (body.size - 1) ) {
//} // ---------- private fun moveThatBody(){
