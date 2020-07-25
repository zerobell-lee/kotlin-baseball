package `class`.school

import java.time.LocalDate

open class Person(val name: String,
                  val birthday: LocalDate,
                  val gender: Gender? = Gender.UNKNOWN,
                  var height: Double) {

    constructor(name: String,
                birthdayString: String,
                genderString: String,
                height: Double) : this(name, LocalDate.parse(birthdayString), Gender.valueOf(genderString), height)

    protected open fun generateIntroduceStr(): String {
        val sb = StringBuilder("Hello, my name is $name, I was born in $birthday.\n")
        sb.append(when(gender) {
            Gender.UNKNOWN -> "I don't want to say my gender.\n"
            Gender.THIRD -> "I'm not male, and female neither.\n"
            else -> "I'm $gender.\n"
        })
        return sb.toString()
    }

    fun introduce() {
        println(generateIntroduceStr())
    }

    fun heighten(delta: Int) {
        height += delta
        println("I've grown up! Now I'm $height cm tall.")
    }

    fun isAdult(): Boolean {
        return (LocalDate.now().year - birthday.year) > 19
    }
}