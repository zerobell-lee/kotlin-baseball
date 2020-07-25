package string.caesar

import java.lang.IndexOutOfBoundsException
import java.lang.Integer.parseInt
import java.lang.NumberFormatException

fun main() {
    while (true) {
        print("Input like {plaintext} {key} : ")
        try {
            val (plaintext, key) = readLine()!!.split(' ')
            println("result : ${encrypt(plaintext, parseInt(key))}")
        } catch (ex: NumberFormatException) {
            println("You bastard, put your key in numeric format on second place.")
        } catch (ex: IndexOutOfBoundsException) {
            println("You bastard, put plaintext on first place, then put key on second place.")
            continue
        }
    }
}

fun pushChar(c: Char, key: Int): Char {
    val baseNum: Int = when (c) {
        in 'a'..'z' -> 'a'.toInt()
        in 'A'..'Z' -> 'A'.toInt()
        else -> null
    }
        ?: return c
    return (((c.toInt() - baseNum + key) % 26) + baseNum).toChar()
}

fun encrypt(s: String, key: Int): String {
    val refinedKey = refineKey(key)
    return s.map { c: Char -> pushChar(c, refinedKey) }.joinToString("")
}

fun refineKey(key: Int): Int {
    return when {
        key >= 26 -> key % 26
        key < 0 -> 26 - (key * -1) % 26
        else -> key
    }
}