package string.anagram

fun main() {
    while(true) {
        print("Put two strings separated by space : ")
        val inputStr = readLine()!!.split(' ')
        if (inputStr.size != 2) {
            println("Invalid input. less or more than 2 Strings")
            continue
        }
        val (left, right) = inputStr.map { s: String -> s.filter { c -> c.isLetter() } }
        println("$left and $right are ${if (areAnagrams(left, right)) "\b" else "not"} anagrams.")
    }
}

fun areAnagrams(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) return false

    val alphabetCountArray1 = Array(26) {0}
    val alphabetCountArray2 = Array(26) {0}

    for (i in s1.indices) {
        val (c1, c2) = Pair(s1[i], s2[i])
        alphabetCountArray1[c1.toUpperCase() - 'A']++
        alphabetCountArray2[c2.toUpperCase() - 'A']++
    }

    return alphabetCountArray1.contentEquals(alphabetCountArray2)
}