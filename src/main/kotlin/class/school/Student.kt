package `class`.school

import java.lang.IllegalArgumentException

class Student(name: String,
              birthdayString: String,
              genderString: String,
              height: Double) : Person(name, birthdayString, genderString, height) {
    var grade: Int? = null
        set(value) {
            when (value) {
                in 1..3 -> field = value
                else -> throw IllegalArgumentException("Grade should be in range 1~3")
            }
        }

    override fun generateIntroduceStr(): String {
        val sb = StringBuilder(super.generateIntroduceStr())
        sb.append("I'm a student.\n")
        grade?.let {
            sb.append("I'm in ${when (grade) {
                1 -> "1st"
                2 -> "2nd"
                3 -> "3rd"
                else -> throw IllegalArgumentException("Impossible Grade")
            }
            } grade.")
        }
        return sb.toString()
    }
}