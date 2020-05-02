package xyz.zerobell

import java.lang.Exception
import java.lang.Integer.parseInt
import java.lang.RuntimeException
import java.util.*
import kotlin.collections.ArrayList

val random = Random()

const val STRIKE = 0
const val BALL = 1
const val OUT = 2

fun main() {
    while(setupGame()) {
        continue
    }
}

fun generateRandomNumber(): Int {
    return random.nextInt(9) + 1
}

fun generateAnswer(): List<Int> {
    val answer = ArrayList<Int>()
    while (answer.size < 3) {
        val tmpNum = generateRandomNumber()
        if (tmpNum !in answer) {
            answer.add(tmpNum)
        }
    }
    return answer
}

fun parseInputNumber(numStr: String): List<Int> {
    try {
        parseInt(numStr)
    } catch (ex: Exception) {
        throw RuntimeException("String is not parsable")
    }
    if (numStr.length != 3) {
        throw RuntimeException("Input number should have 3 digits")
    }
    if (numStr.toList().distinct().count() != 3) {
        throw RuntimeException("Input number should contain 3 different numbers")
    }
    return numStr.toList().map { c -> c - '0' }
}

fun getResult(answer: List<Int>, input: List<Int>): List<Int> {
    val result = mutableListOf(0, 0, 3)
    for (i in 0..2) {
        for (j in 0..2) {
            if (answer[i] == input[j]) {
                if (i == j) {
                    result[STRIKE]++
                } else {
                    result[BALL]++
                }
                result[OUT]--
                continue
            }
        }
    }
    return result
}

fun printResult(result: List<Int>) {
    println("STRIKE : ${result[STRIKE]}, BALL : ${result[BALL]}, OUT : ${result[OUT]}")
}

fun playGame(answer: List<Int>): Boolean {
    print("Input your number : ")
    val inputStr = readLine() ?: throw RuntimeException("Input value should not be null")
    val inputNumber = parseInputNumber(inputStr)
    val result = getResult(answer, inputNumber)
    printResult(result)
    return result[STRIKE] == 3
}

fun setupGame(): Boolean {
    val answer = generateAnswer()
    while (!playGame(answer))
        continue
    println("Congrats! Do you want 1 more game? (Y/N)")
    val continuable = readLine() ?: "N"
    return "Y".equals(continuable, true)
}