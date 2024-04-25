package priorityQueue

import java.util.PriorityQueue

class `1781` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { -it.second }))
        repeat(n) {
            val (deadLine, cnt) = readLine().split(" ").map { it.toInt() }
            pq.add(deadLine to cnt)
        }
        var total = 0
        var day = 1
        val minPq = PriorityQueue<Int>()
        while (pq.isNotEmpty()) {
            val (deadLine, cnt) = pq.poll()
            total += cnt
            minPq.offer(cnt)
            if (pq.isNotEmpty() && day == pq.peek().first) {
                while (pq.isNotEmpty() && deadLine == pq.peek().first) {
                    val nextCnt = pq.poll().second
                    if (nextCnt > minPq.peek()) {
                        total -= minPq.poll()
                        total += nextCnt
                        minPq.add(nextCnt)
                    }
                }
            }
            day++
        }
        println(total)
    }
}

fun main() {
    `1781`().solution()
}