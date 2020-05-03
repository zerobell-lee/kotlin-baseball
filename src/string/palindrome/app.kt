package string.palindrome

fun main() {
    while (true) {
        print("Put your string : ")
        val str = readLine() ?: continue
        val (result, breakpoint) = isPalindrome(str)
        if (result) {
            println("Yes, $str is palindrome.")
            continue
        }
        println("No, $str is not a palindrome. breakpoint is $breakpoint")
    }
}

fun isPalindrome(s: String): Pair<Boolean, Pair<Char, Char>?> {
    val filteredS = s.filter { c -> c.isLetterOrDigit() }
    for (i in filteredS.indices) {
        val (front, rear) = getPairOfChar(filteredS, i)
        if (front.toUpperCase() != rear.toUpperCase())
            return Pair(false, Pair(front, rear))
    }
    return Pair(true, null)
}

fun getPairOfChar(s: String, i: Int): Pair<Char, Char> {
    return Pair(s[i], s[s.length - i - 1])
}