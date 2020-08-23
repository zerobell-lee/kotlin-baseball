package `class`.unit

import java.math.BigDecimal

class Gram constructor(val value: BigDecimal) {
    init {

    }
    companion object {
        private val KILO = BigDecimal.valueOf(1000)
        fun kg(value: String): Gram {
            return Gram(BigDecimal(value) * KILO)
        }
    }
    constructor(value: String): this(BigDecimal(value))
    constructor(value: Long): this(BigDecimal.valueOf(value))

    operator fun plus(other: Gram): Gram {
        return Gram(value + other.value)
    }
    operator fun minus(other: Gram): Gram {
        return Gram(value - other.value)
    }
    operator fun times(other: Gram): Gram {
        return Gram(value * other.value)
    }
    operator fun div(other: Gram): Gram {
        return Gram(value.divide(other.value))
    }

    override fun toString(): String {
        return value.stripTrailingZeros().toPlainString() + "g"
    }
    fun kg(): String {
        return (value.divide(KILO)).stripTrailingZeros().toPlainString() + "kg"
    }
}