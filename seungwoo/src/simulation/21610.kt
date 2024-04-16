package simulation

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

class `21610` {
    private data class Node(val x: Int, val y: Int)

    private var map: Array<IntArray> = arrayOf()
    private val cloudsQ = LinkedList<Node>() as Queue<Node>
    private val d = listOf(
        Node(0, -1),
        Node(-1, -1),
        Node(-1, 0),
        Node(-1, 1),
        Node(0, 1),
        Node(1, 1),
        Node(1, 0),
        Node(1, -1)
    )

    private fun moveAndWatering(n: Int, dir: Int, s: Int) {
        val size = cloudsQ.size
        repeat(size) {
            val (x, y) = cloudsQ.poll()
            val nx = findPos(n, x, d[dir].x * s)
            val ny = findPos(n, y, d[dir].y * s)
            map[nx][ny]++
            cloudsQ.offer(Node(nx, ny))
        }
    }

    private fun findPos(n: Int, cur: Int, dis: Int): Int {
        var total = cur + dis
        return if (total >= 0) total % n
        else {
            while (total < 0) total += n
            total
        }
    }

    private fun copyWaterMagic(n: Int): Array<BooleanArray> {
        val canMakeCloud = Array(n) { BooleanArray(n) { true } }
        while (cloudsQ.isNotEmpty()) {
            val (x, y) = cloudsQ.poll()
            for (i in 1 until d.size step 2) {
                val nx = x + d[i].x
                val ny = y + d[i].y
                if (nx !in map.indices || ny !in map.indices) continue
                if (map[nx][ny] > 0) map[x][y]++
            }
            canMakeCloud[x][y] = false
        }
        return canMakeCloud
    }

    private fun makeClouds(canMakeCloud: Array<BooleanArray>) {
        for (x in map.indices) {
            for (y in map.indices) {
                if (!canMakeCloud[x][y]) continue
                if (map[x][y] >= 2) {
                    map[x][y] -= 2
                    cloudsQ.offer(Node(x, y))
                }
            }
        }
    }

    private fun calcWaterSum(): Int {
        return map.sumOf { it.sum() }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().splitToInt()
        map = Array(n) {
            val st = StringTokenizer(readLine())
            IntArray(n) { st.nextToken().toInt() }
        }
        cloudsQ.apply {
            offer(Node(n - 1, 0))
            offer(Node(n - 1, 1))
            offer(Node(n - 2, 0))
            offer(Node(n - 2, 1))
        }
        repeat(m) {
            val (d, s) = readLine().splitToInt()
            moveAndWatering(n, d - 1, s)
            val canMakeCloud = copyWaterMagic(n)
            makeClouds(canMakeCloud)
        }
        println(calcWaterSum())
    }

    private fun String.splitToInt(): List<Int> = split(" ").map { it.toInt() }
}

fun main() {
    `21610`().solution()
}