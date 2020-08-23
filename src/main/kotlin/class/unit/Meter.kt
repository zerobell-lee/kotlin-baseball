package `class`.unit

import java.math.BigDecimal

class Meter constructor(val value: BigDecimal) {
    companion object {
        private val CENTI = BigDecimal.valueOf(0.01)
        private val MILLI = BigDecimal.valueOf(0.001)
        private val KILO = BigDecimal.valueOf(1000)
        fun cm(value: String): Meter {
            return Meter(BigDecimal(value) * CENTI)
        }
        fun mm(value: String): Meter {
            return Meter(BigDecimal(value) * MILLI)
        }
        fun km(value: String): Meter {
            return Meter(BigDecimal(value) * KILO)
        }
    }
    constructor(value: Long): this(BigDecimal.valueOf(value))
    constructor(value: String): this(BigDecimal(value))

    operator fun plus(other: Meter): Meter {
        return Meter(value + other.value)
    }
    operator fun plus(other: Long): Meter {
        return this.plus(Meter(other))
    }
    operator fun minus(other: Meter): Meter {
        return Meter(value - other.value)
    }
    operator fun minus(other: Long): Meter {
        return this.minus(Meter(other))
    }
    operator fun times(other: Long): Meter {
        return Meter(value * BigDecimal.valueOf(other))
    }
    operator fun div(other: Long): Meter {
        return Meter(value / BigDecimal.valueOf(other))
    }
    fun cm(): String {
        return (value / CENTI).stripTrailingZeros().toPlainString() + "cm"
    }
    override fun toString(): String {
        return value.stripTrailingZeros().toPlainString() + "m"
    }
    fun mm(): String {
        return (value / MILLI).stripTrailingZeros().toPlainString() + "mm"
    }
    fun km(): String {
        return (value / KILO).stripTrailingZeros().toPlainString() + "km"
    }
}