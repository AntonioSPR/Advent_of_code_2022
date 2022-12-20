// Find all the directories with a total size of at most 100000.
// Part 1: What is the sum of the total sizes of those directories?

fun day07(){
    val title = """
        
        ====================================
        =      Advent  of  code  2022      =
        =  Day 7: No Space Left On Device  =
        ====================================
        
    """.trimIndent()
    println(title)

    // Read the file with the input into a string
    val input: String = filenameToString("day07_input.txt")

    //  Pass the input to the functions that solve the puzzles
    day07Part1(input)
    day07Part2(input)

    // Give some time to the user to read the messages
    print( "          (Press return to continue)" )
    readLine()

} // --------------------------------------------- fun day07(){


fun day07Part1(input: String) {
    // Find all the directories with a total size of at most 100000.
    // What is the sum of the total sizes of those directories?

    val directoryTree = DirectoryTree(input)

    var directoriesNames = ""
    var sumDirectoriesSizes = 0

    directoryTree.directoriesSizes.forEach{ (dirName, dirSize) ->
        if (dirSize <= 100000 ){
            sumDirectoriesSizes += dirSize
            directoriesNames += dirName + " - "
        }
    }
    var text = "--- Part One ---\n"
    text += "The names of the directories with a total size of at most 100000 are:\n"
    text += directoriesNames
    text += "\nand their sizes sum: $sumDirectoriesSizes "
    println(text)

} // ---------------------------------------- fun day07Part1(input: String) {


fun day07Part2(input: String) {
    // Part 2: Find the smallest directory that, if deleted, would free up enough space on the filesystem to run the update.
    // What is the total size of that directory?

    val totalDiskSpace = 70000000
    val spaceNeededToUpdate = 30000000
    val directoryTree = DirectoryTree(input)
    val freeSpaceInDisk = 70000000 - directoryTree.directoriesSizes["/"]!!
    val spaceNeededToFreeUp = spaceNeededToUpdate - freeSpaceInDisk

    var nameOfDirToDelete = ""
    var sizeOfDirToDelete = 70000000

    directoryTree.directoriesSizes.forEach{ (dirName, dirSize) ->
        if (dirSize >= spaceNeededToFreeUp &&  dirSize < sizeOfDirToDelete ){
            sizeOfDirToDelete = dirSize
            nameOfDirToDelete = dirName
        }
    }
    var text = "--- Part Two ---\n"
    text += "The directory to delete is $nameOfDirToDelete which has a size of $sizeOfDirToDelete\n"
    println(text)

} // ---------------------------------------- fun day07Part27
// (input: String) {


class DirectoryTree(val input: String){

    // variable to store the sizes of the directories
    var directoriesSizes = mutableMapOf<String, Int>()
    var inputTree : List<String>

    init {
        inputTree = input.split('\n')
        findDirectoriesSizes("/", 1) // Skip the "cd /" command
    }

    fun findDirectoriesSizes(dirName: String, beginIndex : Int = 0): Int {  // The return value is the size of the current dir
        var index = beginIndex
        directoriesSizes[dirName] = directoriesSizes[dirName] ?: 0 // If necessary, init the size

        while(index < inputTree.size) {
            when (inputTree[index][0]) {
                in ('0'..'9') -> { // Current line is a file. Add file size to currentDirSize
                    directoriesSizes[dirName] = (directoriesSizes[dirName] ?: 0 ) +  inputTree[index].split(' ')[0].toInt()
                    index++
                }
                'd' -> index++ // Current line is a directory.
                '$' -> {// Current line is a command.
                    when(inputTree[index]){
                        "\$ ls" -> index++
                        "\$ cd .." -> {
                            return ++index
                        }
                        else -> {// $ dir loremIpsum
                            var subDirName = ""
                            if(dirName == "/")
                                subDirName = "/" + inputTree[index].split(' ')[2]
                            else
                                subDirName = dirName + "/" + inputTree[index].split(' ')[2]

                            index = findDirectoriesSizes(subDirName, ++index)
                            directoriesSizes[dirName] = (directoriesSizes[dirName] ?: 0) + (directoriesSizes[subDirName] ?: 0)
                        }
                    } // ----- when(...
                }
            } // ----- when(...
        } // ----- while(...

        return index
    } // --------------------     fun findDirectoriesSizes(dirName: String, beginIndex : Int = 0): Int {  // The return value is the size of the current dir

    override fun toString(): String {
        return directoriesSizes.toString()
    }

} // ---------------------------------------- class DirectoryTree(val inputTree: String){
