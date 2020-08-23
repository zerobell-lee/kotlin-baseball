package `class`.unit

fun String.g(): Gram {
    return Gram(this)
}
fun String.kg(): Gram {
    return Gram.kg(this)
}
fun String.m(): Meter {
    return Meter(this)
}
fun String.mm(): Meter {
    return Meter.mm(this)
}
fun String.cm(): Meter {
    return Meter.cm(this)
}
fun String.km(): Meter {
    return Meter.km(this)
}

fun main() {
    val myHeight = "168.8".cm()
    val myWeight = "68".kg()
    val geun = "600".g()

    println("I'm ${myHeight.cm()} tall. I weigh ${myWeight.kg()}")
    println("1 geun eqauls ${geun}")

    val a = "3".kg()
    val b = "450".g()
    val c = a + b;

    println("${a.kg()} + ${b} = ${c.kg()}")
}