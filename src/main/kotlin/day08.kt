// --- Day 8: Treetop Tree House ---
// Part 1: Find how many trees are visible from outside the grid (Al trees between are shorter)
// Part 2: Find the highest scenic score possible for any tree

fun day08(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =    Day 8:Treetop  Tree  House    =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day08_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day08Part1(input)
    day08Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day08(){

fun day08Part1(input: String) {
    // Part 1: Find how many trees are visible from outside the grid

    val forest = Forest(input)

    var text = "--- Part One ---\n"
    text += "There are ${forest.visibleTrees.size} visible trees\n"
    println(text)

} // ---------------------------------------- fun day08Part1(input: String) {

fun day08Part2(input: String) {
    // Part 2: Find the highest scenic score possible for any tree
    // 278400 Too low; 313200

    val forest = Forest(input)

    var text = "--- Part Two ---\n"
    text += "The tree with the highest score is i:${forest.highScenicScoreTree.i}, j:${forest.highScenicScoreTree.j}"
    text += "with a scenic score of ${forest.scenicScores[forest.highScenicScoreTree.i][forest.highScenicScoreTree.j]}  \n"
    println(text)

} // ---------------------------------------- fun day08Part2(input: String) {

class Tree(val i: Int, val j: Int, val h: Int, var score: Int = 0) {
    override fun toString(): String {
        val text : String
        if (score == 0)
            text = "i-index:$i --- j-index:$j --- height:$h"
        else
            text = "i-index:$i --- j-index:$j --- height:$h --- score:$score"

        return text
    }

} // ------------ class Tree(val i: Int, val j: Int, val h: Int, var score: Int = 0) {

class Forest(input: String) {

    var inputLines : List<String>
    val visibleTrees : MutableList<Tree> = mutableListOf<Tree>()
    val scenicScores : Array<Array<Int>>
    private var iMax : Int
    private var jMax : Int
    val highScenicScoreTree : Tree
    
    init {
        inputLines = input.lines()
        scenicScores = Array(inputLines.size){ Array(inputLines[0].length){0} }
        iMax = inputLines.size - 1
        jMax = inputLines[0].length - 1
        fillVisibleTreesList()
        fillScenicScoresArray()
        highScenicScoreTree = findHighScenicScore()
    } // ---------- init {
    
    private fun fillVisibleTreesList() {
        for (i in inputLines.indices)
            for (j in inputLines[i].indices)
                if (isVisible(i, j))
                    visibleTrees.add(Tree(i, j, inputLines[i][j].digitToInt()))
    } // ------------ private fun findVisibleTrees() {

    private fun isVisible(i: Int, j: Int): Boolean {
        val tree = inputLines[i][j]
        var visibleTop    = true
        var visibleBottom = true
        var visibleLeft   = true
        var visibleRight  = true

        if (i==0 || i==iMax || j==0 || j==jMax)
            return true

        // Compare with the TOP trees
        for (k in 0 until i)
            if (tree <= inputLines[k][j]) {
                visibleTop = false
                break
            }
        // Compare with the BOTTOM trees
        for (k in i+1..iMax)
            if (tree <= inputLines[k][j]) {
                visibleBottom = false
                break
            }
        // Compare with the LEFT trees
        for (k in 0 until j)
            if (tree <= inputLines[i][k]) {
                visibleLeft = false
                break
            }
        // Compare with the RIGHT trees
        for (k in j+1..jMax)
            if (tree <= inputLines[i][k]) {
                visibleRight = false
                break
            }

        return visibleTop || visibleBottom || visibleLeft || visibleRight
    } // ------------ private fun isVisible(i: Int, j: Int): Boolean {

    private fun fillScenicScoresArray() {
        for (i in inputLines.indices) {
            for (j in inputLines[i].indices) {
                scenicScores[i][j] = findScenicScoreOfTree(i, j)
            }
        }
    } // ------------ private fun fillScenicScoresArray() {

    private fun findScenicScoreOfTree(i: Int, j: Int): Int {
        var scoreTop = 0
        var scoreBottom = 0
        var scoreLeft = 0
        var scoreRight = 0
        val treeHeight = inputLines[i][j].digitToInt()

        // Compare with the TOP trees
        for (k in i-1 downTo  0) {
            scoreTop++
            if (treeHeight <= inputLines[k][j].digitToInt())
                break
        }
        // Compare with the BOTTOM trees
        for (k in i+1..iMax) {
            scoreBottom++
            if (treeHeight <= inputLines[k][j].digitToInt())
                break
        }
        // Compare with the LEFT trees
        for (k in j-1 downTo  0) {
            scoreLeft++
            if (treeHeight <= inputLines[i][k].digitToInt())
                break
        }
        // Compare with the RIGHT trees
        for (k in j+1..jMax) {
            scoreRight++
            if (treeHeight <= inputLines[i][k].digitToInt())
                break
        }

        return scoreTop * scoreBottom * scoreLeft * scoreRight
    } // ------------ private fun findScenicScore(i: Int, j: Int): Int {

    private fun findHighScenicScore(): Tree{
        var highSceneTree = Tree(0,0,0, 0)
        for (i in scenicScores.indices){
            for(j in scenicScores[i].indices){
                if (scenicScores[i][j] > highSceneTree.score){
                    highSceneTree = Tree(i, j, inputLines[i][j].digitToInt(), scenicScores[i][j])
                }
            }
        }
        return highSceneTree
    } // ---------- fun findHighScenicScore(): Tree{

    override fun toString(): String {
        return inputLines.toString()
    } // ----------override fun toString(): String {

} // ------------------------------ class Forest(input: String) {

