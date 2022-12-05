import java.io.File
import java.io.InputStream
import kotlin.system.exitProcess

// assortedFunctions.kt
// functions that are used in several files

fun ordinal(number: Int): String {
    val letters = when(number) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
    return letters

}  // ---------- fun ordinal(number: Int): String {

fun filenameToString(fileName: String): String{
    // Function that receives a string that is a file name, read it and returns a string with the content of the file

    try {
        val inputStream: InputStream = File(fileName).inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }

        return inputString
    }
    catch(E: Exception){
        println("\n --------- Read file error -> file $fileName NOT FOUND ---------\n")
        exitProcess(69)
    }

}  // ---------- fun ordinal(number: Int): String {