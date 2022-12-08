import java.io.File

fun main() {
    dayOne()
}

fun dayOne() {
    val sums = ArrayList<Int>()
    var currSum = 0
    File("InputData/1.txt").forEachLine {
        if (it.isEmpty()){
            sums.add(currSum)
            currSum = 0
        } else {
            currSum += it.toInt()
        }
    }
    println(sums.maxBy { it })
}