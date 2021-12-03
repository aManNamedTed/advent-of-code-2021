import kotlin.io.path.*
import kotlin.reflect.typeOf

fun main(args: Array<String>) {
    val fileName:String = "day03.txt"
    val answerOne:Int = partOne(fileName, 1)
    val answerTwo:Int = partTwo(fileName, 2)

    println("Answer One: $answerOne")
    println("Answer Two: $answerTwo")
}

// LOL. will figure out how to fix overloading funcs in same main package later... just wanna solve day 3 first
fun partOne(fileName:String, stub:Int): Int {
    val input: List<String> = Path(fileName).readLines()
    var gammaRateBitArray:IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0)
    var epsilonRateBitArray:IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0)
    var bitVector:IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0)
    for (i in input.indices) {
        var bString:String = input[i]
        for(j in bString.indices) {
            if(bString[j].toString() == "0") {
                bitVector[j] -= 1
            } else if (bString[j].toString() == "1"){
                bitVector[j] += 1
            }
        }
    }
    for (i in bitVector.indices) {
        // if   bitVector[i] in [1, inf), 1s occurred more; 1 is MCB, 0 is LCB
        if (bitVector[i] > 0){
            gammaRateBitArray[i] = 1
            epsilonRateBitArray[i] = 0
        // else bitVector[i] in (-inf,0], 0s occurred more; 0 is MCB, 1 is LCB
        } else {
            gammaRateBitArray[i] = 0
            epsilonRateBitArray[i] = 1
        }
    }
    val gammaRate:Int = gammaRateBitArray.joinToString("").toInt(2)
    val epsilonRate:Int = epsilonRateBitArray.joinToString("").toInt(2)
    return gammaRate * epsilonRate
}

fun partTwo(fileName: String, stub:Int): Int {
    val input: List<String> = Path(fileName).readLines()
    for (i in input.indices) {
    }
    return 2
}
