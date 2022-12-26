// Solutions to the puzzles of Advent of Code 2022
// https://adventofcode.com/2022

fun main() {
    val title = """
        
        
        =================================
        =                               =
        =      Advent of Code 2022      =
        =       (Kotlin  edition)       =
        =                               =
        =================================
         
        """.trimIndent()
    var doYouWantToPrintTitle = true // a var name which not need comments

    // A menu with instructions
    var menu = "\n"
    for (i in 1..25){
        menu += String.format("% 3d", i) + ".- Day" + String.format("%02d", i) + "\t\t"
        if (i % 5 == 0){
            menu += "\n"
        }
    }
    menu += "What puzzle (day) do you want to solve? (0 = Exit): "

    while(true){
        try{
            if (doYouWantToPrintTitle) {
                println(title)
            }
            else {
                doYouWantToPrintTitle = true
            }

            print(menu)

            // Read the response.
            val response: String = readLine().toString()
            val day = response.toInt()

            // If the response is 0 exit.
            if (day == 0) {
                break
            }

            // If the response is in 1..25 make puzzle, else repeat the menu.
            check(day in 1..25)

            when(day){  // TODO Change this "when" for an array
                1 -> day01()
                2 -> day02()
                3 -> day03()
                4 -> day04()
                5 -> day05()
                6 -> day06()
                7 -> day07()
                8 -> day08()
                9 -> day09()
                10 -> day10()
                11 -> day11()
                12 -> day12()
                13 -> day13()
                14 -> day14()
                15 -> day15()
                16 -> day16()
                17 -> day17()
                18 -> day18()
                19 -> day19()
                20 -> day20()
                21 -> day21()
                22 -> day22()
                23 -> day23()
                24 -> day24()
                25 -> day25()
            }
        }
        catch (e: Exception){
            doYouWantToPrintTitle = false // you don't print title after an error
        }
    }

} // ---------------------------------------- fun main() {
