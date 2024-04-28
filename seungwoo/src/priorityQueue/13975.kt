package priorityQueue

import java.util.PriorityQueue
import java.util.StringTokenizer

class `13975` {
    private val pq = PriorityQueue<Long>()

    fun solution() = with(System.`in`.bufferedReader()) {
        val t = readLine().toInt()
        val sb = StringBuilder()
        repeat(t) {
            val k = readLine().toInt()
            val st = StringTokenizer(readLine())
            repeat(k) { pq.add(st.nextToken().toLong()) }
            var cost = 0L
            while (pq.size > 1) {
                val tempFileCost = pq.poll() + pq.poll()
                cost += tempFileCost
                pq.add(tempFileCost)
            }
            pq.clear()
            sb.append("$cost\n")
        }
        println(sb)
    }
}

fun main() {
    `13975`().solution()
}