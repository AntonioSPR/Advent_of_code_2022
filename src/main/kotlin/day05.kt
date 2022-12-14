// --- Day 5: Supply Stacks ---
// Find what crate ends up on top of each stack
// Part 2: move multiple crates at once

fun day05(){

    val title = """
    
        =============================
        =    Advent of code 2022    =
        =    Day 5: Supply Stacks    =
        =============================
        
       """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day05_input.txt")

    //  Pass the input to the functions that solve the puzzles
    input.day05Part1()
    input.day05Part2()

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // ---------------------------------------- fun day05(){

fun String.day05Part1(){
    // --------- Find what crate ends up on top of each stack ---------

    val inputLines = this.lines()
    val linesStack = StackWithList()
    var index = 0 // I need the same index to go thru in two different for-loops

    // --------- Save the lines with the stacks in a stack ---------
    while (index < inputLines.size && inputLines[index] != ""){
        linesStack.push(inputLines[index])
        index++
    }

    // We left the loop in inputLines[i] == ""
    // Now inputLines[i] is the first movement. Later we use it
    index++

    // Top line contains the amount of stacks
    val lineWithStacksNumbers = linesStack.pop().toString().trim()
    val arrayWithStacksNumbers = lineWithStacksNumbers.split("   ")
    val amountOfStacks = arrayWithStacksNumbers[arrayWithStacksNumbers.size - 1].trim('[').trim(']').toInt()

    // --------- Made a map of stacks of crates ---------
    val stacks: MutableMap<Int, StackWithList> = mutableMapOf()
    for (i in 1..amountOfStacks){
        stacks[i] = StackWithList()
    }


    // --------- Now fill the stacks of crates ---------
    // Get a row of crates
    var rowOfCrates = linesStack.pop()
    while (rowOfCrates != null){
        // If row of crates not null read the crates inside
        val stringOfCrates = rowOfCrates.toString()
        for (i in 0 until stringOfCrates.length ){
            val separators = arrayOf(' ', '[', ']')
            if (stringOfCrates[i]  !in separators ) {
                // If the char is not a separator, push it in a stack
                val numberOfStack = (i - 1) / 4 + 1
                stacks[numberOfStack]!!.push(stringOfCrates[i])
            }
        }
        // Get another row of crates
        rowOfCrates = linesStack.pop()
    }

//    // lets do a test
//    for(i in 1..stacks.size){
//        println("------------------------------ stack number: $i ---------------------")
//        var text = ""
//        while(!stacks[i]!!.isEmpty()){
//            val box = stacks[i]!!.pop()
//            text += box.toString()
//        }
//        println(text)
//    }

    // --------- The stacks of crates are now filled.
    // --------- Go to read the commands and move the crates between the stacks
    for( j in index until inputLines.size){
        val moveCommand = inputLines[j].split(" ")
        val amountOfMoves = moveCommand[1].toInt()
        val  beginStack = moveCommand[3].toInt()
        val  endStack = moveCommand[5].toInt()
        for(k in 0 until amountOfMoves){
            val crate: String = stacks[beginStack]!!.pop().toString()
            stacks[endStack]!!.push(crate)
        }
    }

    // ----- Peek the top of the stacks

    var text = "--- Part One ---\n"
    text += "The crates al the top of the stacks are: "
    for (i in 1..stacks.size){
        text += stacks[i]!!.peek()
    }
    println(text)

} // ---------------------------------------- fun day05Part1(inputString: String) {


fun String.day05Part2(){
    // --------- Find what crate ends up on top of each stack ---------

    val inputLines = this.lines()
    val linesStack = StackWithList()
    var index = 0 // I need the same index to go thru in two different for-loops

    // --------- Save the lines with the stacks in a stack ---------
    while (index < inputLines.size && inputLines[index] != ""){
        linesStack.push(inputLines[index])
        index++
    }

    // We left the loop in inputLines[i] == ""
    // Now inputLines[i] is the first movement. Later we use it
    index++

    // Top line contains the amount of stacks
    val lineWithStacksNumbers = linesStack.pop().toString().trim()
    val arrayWithStacksNumbers = lineWithStacksNumbers.split("   ")
    val amountOfStacks = arrayWithStacksNumbers[arrayWithStacksNumbers.size - 1].trim('[').trim(']').toInt()

    // --------- Made a map of stacks of crates ---------
    val stacks: MutableMap<Int, StackWithList> = mutableMapOf()
    for (i in 1..amountOfStacks){
        stacks[i] = StackWithList()
    }


    // --------- Now fill the stacks of crates ---------
    // Get a row of crates
    var rowOfCrates = linesStack.pop()
    while (rowOfCrates != null){
        // If row of crates not null read the crates inside
        val stringOfCrates = rowOfCrates.toString()
        for (i in 0 until stringOfCrates.length ){
            val separators = arrayOf(' ', '[', ']')
            if (stringOfCrates[i]  !in separators ) {
                // If the char is not a separator, push it in a stack
                val numberOfStack = (i - 1) / 4 + 1
                stacks[numberOfStack]!!.push(stringOfCrates[i])
            }
        }
        // Get another row of crates
        rowOfCrates = linesStack.pop()
    }

    // --------- The stacks of crates are now filled.
    // --------- Go to read the commands and move the crates between the stacks
    // --------- New rules, we move multiple crates at once
    for( j in index until inputLines.size){
        val moveCommand = inputLines[j].split(" ")
        val amountOfMoves = moveCommand[1].toInt()
        val  beginStack = moveCommand[3].toInt()
        val  endStack = moveCommand[5].toInt()
        val auxStack = StackWithList()
        for(k in 0 until amountOfMoves){
            val crate: String = stacks[beginStack]!!.pop().toString()
            auxStack.push(crate)
        }
        for(k in 0 until amountOfMoves){
            val crate: String = auxStack.pop().toString()
            stacks[endStack]!!.push(crate)
        }
    }

    // ----- Peek the top of the stacks

    var text = "--- Part Two ---\n"
    text += "The crates al the top of the stacks are: "
    for (i in 1..stacks.size){
        text += stacks[i]!!.peek()
    }
    println(text)

} // ---------------------------------------- fun day05Part2(inputString: String) {
