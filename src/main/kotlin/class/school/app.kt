package `class`.school

fun main() {
    val persons: List<Person> = listOf(Person("Brown", "2020-01-01", "MALE", 185.0),
    Person("Cony", "2020-01-02", "FEMALE", 165.0),
    Person("Edward", "1994-03-10", "THIRD", 10.0),
    Student("Kei", "1995-03-20", "FEMALE", 160.0),
    Student("Choerry", "2001-01-01", "UNKNOWN", 163.0))

    val choerry: Student = persons.first { p -> p.name == "Choerry" } as Student
    choerry.grade = 3

    persons.forEach(Person::introduce)
}