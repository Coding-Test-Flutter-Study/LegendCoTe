package priorityQueue

import java.util.PriorityQueue

class `1715` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val pq = PriorityQueue<Long>()
        repeat(n) {
            pq.add(readLine().toLong())
        }
        var result = 0L
        while (pq.size > 1) {
            val min = pq.poll()
            val next = pq.poll()
            result += min + next
            pq.add(min + next)
        }
        println(result)
    }
}

fun main() {
    `1715`().solution()
}