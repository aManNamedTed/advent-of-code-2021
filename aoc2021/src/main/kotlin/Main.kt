import kotlin.io.path.*

fun main(args: Array<String>) {
    val answerOne:Int = partOne()
    val answerTwo:Int = partTwo()

    println("Answer One: $answerOne")
    println("Answer Two: $answerTwo")
}

fun partOne(): Int {
    val input:List<String> = Path("day01.txt").readLines()
    var counter:Int = 0
    var lastValue:Int = 0
    for (i in input.indices) {
        if(i == 0) {
            lastValue = input[i].toInt()
            continue
        }
        if(lastValue < input[i].toInt()) {
            counter += 1
        }
        lastValue = input[i].toInt()
    }
    return counter
}

fun partTwo(): Int {
    val input:List<String> = Path("day01.txt").readLines()
    val windowSize:Int = 3
    var counter:Int = 0
    var lastValue:Int = 0

    for (i in windowSize until input.size) {
        val windowA:Int = input[i-3].toInt() + input[i-2].toInt() + input[i-1].toInt()
        val windowB:Int = input[i-2].toInt() + input[i-1].toInt() + input[i-0].toInt()
        if(windowA < windowB) {
            counter += 1
        }
    }
    return counter
}
