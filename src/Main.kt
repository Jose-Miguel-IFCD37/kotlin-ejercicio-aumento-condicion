data class Student(val name: String, val age: Byte, val accredited: Boolean)

val students: Map<String, Student> =
    arrayOf(
        Student("Martin", 19, true),
        Student("Tricia", 22, false),
        Student("Lola", 23, true),
        Student("Pedro", 16, false),
        Student("Alex", 25, true)
    ).associateBy(
        keySelector = { k -> k.name.lowercase() },
        valueTransform = { v -> v }
    )

// Forma directa de crear un diccionario:
//val students2: Map<String, Student> =
//    mapOf(
//        "martin" to Student("Martin", 19, true),
//        "tricia" to Student("Tricia", 22, false),
//        "lola" to Student("Lola", 23, true),
//        "pedro" to Student("Pedro", 16, false),
//        "alex" to Student("Alex", 25, true)
//    )

var student: Student? = null
var studentIsAccredited: Boolean = false
var studentIsOver18: Boolean = false

fun main() {
    print("Introduce tu nombre: ")
    val name: String = readln()

    student = findStudent(name)

    if (student != null) {
        studentIsOver18 = student?.age!! >= 18
        studentIsAccredited = student?.accredited!!

        println("Estudiante encontrado: ${student?.name!!}")

        if (studentIsOver18)
            println("El estudiante es mayor de edad.")
        else
            println("El estudante es menor de edad.")

        if (studentIsAccredited)
            println("El estudante esta acreditado.")
        else
            println("El estudante no esta acreditado.")
    } else {
        println("Estudiante no encontrado.")
    }
}

fun findStudent(name: String): Student? {
    return students[name.lowercase()]
}