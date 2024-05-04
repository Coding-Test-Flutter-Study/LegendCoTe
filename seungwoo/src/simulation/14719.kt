package simulation

import java.util.StringTokenizer
import kotlin.math.min

class `14719` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (h, w) = readLine().split(" ").map { it.toInt() }
        val st = StringTokenizer(readLine())
        val blocks = IntArray(w) { st.nextToken().toInt() }
        var waterAmount = 0
        for (i in 1 until w - 1) {
            var left = 0
            var right = 0
            for (j in 0 until i) {
                if (blocks[j] > left)
                    left = blocks[j]
            }
            for (j in i until w) {
                if (blocks[j] > right)
                    right = blocks[j]
            }
            val height = min(left, right)
            if (height > blocks[i])
                waterAmount += height - blocks[i]
        }
        println(waterAmount)
    }
}

fun main() {
    `14719`().solution()
}