import java.io.File

fun main() {
    dayThree()
}

fun dayThree() {

    val lowerBase = 'a'.code - 1
    val upperBase = 'A'.code - 27
    var out = 0
    File("InputData/3.txt").forEachLine {

        val compartmentLength = it.length / 2
        val compartmentOne = it.substring(0, compartmentLength).toSet()
        val compartmentTwo = it.substring(compartmentLength, it.length).toSet()

        val sharedItem = compartmentOne.intersect(compartmentTwo).take(1)[0]
        if (sharedItem.isLowerCase()) {
            out += sharedItem.code - lowerBase
        } else {
            out += sharedItem.code - upperBase
        }
    }
    println(out)//8153
}
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




