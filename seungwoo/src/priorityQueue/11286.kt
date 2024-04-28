package priorityQueue

import java.util.PriorityQueue
import kotlin.math.abs

class `11286` {
    private val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        if (o1.first != o2.first) o1.first - o2.first
        else o1.second - o2.second
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val sb = StringBuilder()
        repeat(n) {
            when (val num = readLine().toInt()) {
                0 -> {
                    if (pq.isNotEmpty()) sb.append(pq.poll().second)
                    else sb.append(0)
                    sb.append("\n")
                }
                else -> pq.add(Pair(abs(num), num))
            }
        }
        println(sb)
    }
}

fun main() {
    `11286`().solution()
}