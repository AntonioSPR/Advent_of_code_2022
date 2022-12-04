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

