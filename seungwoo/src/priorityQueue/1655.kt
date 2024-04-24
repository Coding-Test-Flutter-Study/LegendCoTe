package priorityQueue

import java.util.Collections
import java.util.PriorityQueue

class `1655` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val sb = StringBuilder()
        var mid = 0
        val midLeft = PriorityQueue<Int>(Collections.reverseOrder())
        val midRight = PriorityQueue<Int>()
        repeat(n) { repeat ->
            val num = readLine().toInt()
            if (repeat == 0) mid = num
            else {
                if (num < mid) midLeft.add(num)
                else midRight.add(num)
            }
            val size = repeat + 1
            if (size % 2 == 0) {
                if (midLeft.size > midRight.size) {
                   midRight.add(mid)
                   mid = midLeft.poll()
                }
            } else {
                if (midRight.size > midLeft.size) {
                    midLeft.add(mid)
                    mid = midRight.poll()
                }
            }
            sb.append("$mid\n")
        }
        println(sb)
    }
}

fun main() {
    `1655`().solution()
}