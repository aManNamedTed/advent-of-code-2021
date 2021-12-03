import kotlin.io.path.*

fun main(args: Array<String>) {
    val fileName:String = "day02.txt"
    val answerOne:Int = partOne(fileName)
    val answerTwo:Int = partTwo(fileName)

    println("Answer One: $answerOne")
    println("Answer Two: $answerTwo")
}

fun partOne(fileName:String): Int {
    val input: List<String> = Path(fileName).readLines()
    var horizontalPosition: Int = 0
    var depth: Int = 0
    for (i in input.indices) {
        val (direction, value) = input[i].split(" ")

        when (direction) {
            "forward" -> horizontalPosition += value.toInt()
            "down" -> depth += value.toInt()
            "up" -> depth -= value.toInt()
        }
    }
    return horizontalPosition * depth
}

fun partTwo(fileName: String): Int {
    val input: List<String> = Path(fileName).readLines()
    var horizontalPosition: Int = 0
    var depth: Int = 0
    var aim: Int = 0
    for (i in input.indices) {
        val (direction, value) = input[i].split(" ")
        when (direction) {
            "forward" -> {
                horizontalPosition += value.toInt()
                depth += aim * value.toInt()
            }
            "down" -> aim += value.toInt()
            "up" -> aim -= value.toInt()
        }
    }
    return horizontalPosition * depth
}
