import java.io.File
import java.util.*

fun main() {
    dayFive()
}

//[P] [F] [R] [P] [Z] [F] [W]     [F] -> [P, F, R, P, Z, F, W, <emptyString>, F]
fun parseRow(str: String) =
    str.replace("[", "")
        .replace("]", "")
        .replace("  ", " ")
        .chunked(2).map {
            it.trim()
        }

fun dayFive() {

    val data = File("InputData/5.txt").readLines()
    val idx = data.indexOf("")

    val nStacks = parseRow(data[idx - 2]).size
    val stacks = Array(nStacks) { Stack<Char>() }

    for (i in idx - 2 downTo 0) {
        val row = parseRow(data[i])
        row.withIndex().forEach {
            if (it.value.isNotEmpty()) {
                stacks[it.index].push(it.value.single())
            }
        }
    }

    for (i in idx + 1 until data.size) {
        val instruction = data[i].split(" ")
        val nPops = instruction[1].toInt()
        val source = instruction[3].toInt() - 1
        val destination = instruction[5].toInt() - 1
        val chars = Array(nPops) { ' ' }
        for (x in 0 until nPops) {
            chars[x] = stacks[source].pop()
        }
        for (ch in chars.reversed()) {
            stacks[destination].push(ch)
        }

    }
    stacks.forEach {
        if (it.isNotEmpty())
            print(it.pop())
    }
}//ZFSJBPRFP


//fun dayFour() {
//    fun parse(str: String) = str.split('-').map { it.toIntOrNull() ?: -1 }
//
//    //fun contains(a: List<Int>, b: List<Int>) = (a[0] >= b[0] && a[1] <= b[1])
//    fun overlap(a: List<Int>, b: List<Int>) = (a[0] >= b[0] && a[0] <= b[1])
//    var count = 0
//    File("InputData/4.txt").forEachLine {
//        val pairStr = it.split(',').map { it -> parse(it) }
//        if (overlap(pairStr[0], pairStr[1]) || overlap(pairStr[1], pairStr[0])) {
//            count++
//        }
//    }
//    println(count.toString() + " / " + File("InputData/4.txt").readLines().size)
//}
//fun dayThreePartTwo() {
//    val lowerBase = 'a'.code - 1
//    val upperBase = 'A'.code - 27
//    var out = 0
//    File("InputData/3.txt").readLines().chunked(3).forEach {
//        val sharedItem = it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet()).take(1)[0]
//        if (sharedItem.isLowerCase()) {
//            out += sharedItem.code - lowerBase
//        } else {
//            out += sharedItem.code - upperBase
//        }
//    }
//    println(out)
//}

//fun dayThree() {
//
//    val lowerBase = 'a'.code - 1
//    val upperBase = 'A'.code - 27
//    var out = 0
//    File("InputData/3.txt").forEachLine {
//
//        val compartmentLength = it.length / 2
//        val compartmentOne = it.substring(0, compartmentLength).toSet()
//        val compartmentTwo = it.substring(compartmentLength, it.length).toSet()
//
//        val sharedItem = compartmentOne.intersect(compartmentTwo).take(1)[0]
//        if (sharedItem.isLowerCase()) {
//            out += sharedItem.code - lowerBase
//        } else {
//            out += sharedItem.code - upperBase
//        }
//    }
//    println(out)//8153
//}
//fun dayTwo() {
//    val opponentChoiceMap = HashMap<String, String>()
//    opponentChoiceMap["A"] = "rock"
//    opponentChoiceMap["B"] = "paper"
//    opponentChoiceMap["C"] = "scissors"
//
//    val myChoiceMap = HashMap<String, String>()
//    myChoiceMap["X"] = "rock"
//    myChoiceMap["Y"] = "paper"
//    myChoiceMap["Z"] = "scissors"
//
//    val choiceScore = HashMap<String, Int>()
//    choiceScore["rock"] = 1
//    choiceScore["paper"] = 2
//    choiceScore["scissors"] = 3
//
//    fun isWin(opponentChoice: String, myChoice: String): Boolean {
//        return ((myChoice == "rock" && opponentChoice == "scissors") ||
//                (myChoice == "paper" && opponentChoice == "rock") ||
//                (myChoice == "scissors" && opponentChoice == "paper"))
//    }
//
//    fun isDraw(opponentChoice: String, myChoice: String) = opponentChoice == myChoice
//
//    var score = 0
//    File("InputData/2.txt").forEachLine {
//        val round = it.split(" ")
//
//        val opponentChoice = opponentChoiceMap[round[0]] ?: ""
//        val myChoice = myChoiceMap[round[1]] ?: ""
//        score += choiceScore[myChoice] ?: 0
//        if (isWin(opponentChoice, myChoice)) {
//            score += 6
//        } else if (isDraw(opponentChoice, myChoice)) {
//            score += 3
//        }
//    }
//    println(score)
//}

//fun dayOne() {
//    val sums = ArrayList<Int>()
//    var currSum = 0
//    File("InputData/1.txt").forEachLine {
//        if (it.isEmpty()){
//            sums.add(currSum)
//            currSum = 0
//        } else {
//            currSum += it.toInt()
//        }
//    }
//    println(sums.maxBy { it })
//}




