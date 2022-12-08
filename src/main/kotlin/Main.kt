import java.io.File

fun main() {
    dayOne()
}

fun dayOne() {
    val result = File("InputData/1.txt")
        .readText()
        .split("\n\n")
        .map {
            it.split("\n").map { v ->
                v.toIntOrNull() ?: 0
            }.sumOf { v -> v }
        }
    println(result.maxBy { it })

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
}