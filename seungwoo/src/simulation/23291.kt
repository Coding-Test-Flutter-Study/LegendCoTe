package simulation

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

class `23291` {
    private data class Node(val x: Int, val y: Int)

    private val oneLine = ArrayDeque<Int>()
    private var cluster: Array<IntArray> = arrayOf()
    private val fishIdxQ = LinkedList<Int>() as Queue<Int>
    private val d = listOf(
        Node(1, 0),
        Node(-1, 0),
        Node(0, 1),
        Node(0, -1),
    )
    private var practiceTurn = 0

    private fun addFishInMinFishCntBowl() {
        var minCnt = MAX_FISH_CNT
        for ((idx, fishCnt) in oneLine.withIndex()) {
            if (fishCnt < minCnt) {
                minCnt = fishCnt
                fishIdxQ.clear()
            }
            if (fishCnt == minCnt) {
                fishIdxQ.offer(idx)
            }
        }
        while (fishIdxQ.isNotEmpty()) {
            oneLine[fishIdxQ.poll()]++
        }
    }

    private fun stackFirstFishBowl() {
        cluster = Array(2) { IntArray(1) { oneLine.removeFirst() } }
    }

    private fun rotateAndMakeCluster() {
        while (cluster.size <= oneLine.size) {
            cluster = rotate90Cluster()
            stackCluster()
        }
    }

    private fun stackCluster() {
        cluster = Array(cluster.size + 1) { x ->
            if (x < cluster.size) cluster[x]
            else IntArray(cluster[0].size) { oneLine.removeFirst() }
        }
    }

    private fun rotate90Cluster(): Array<IntArray> {
        return Array(cluster[0].size) { x ->
            IntArray(cluster.size) { y ->
                cluster[cluster.size - y - 1][x]
            }
        }
    }

    private fun adjustAdjFishCnt() {
        val diffMap = Array(cluster.size) { IntArray(cluster[0].size) }
        for (x in cluster.indices) {
            for (y in cluster[x].indices) {
                for (i in d.indices) {
                    val nx = x + d[i].x
                    val ny = y + d[i].y
                    if (outOfBoundary(nx, ny) || cluster[x][y] <= cluster[nx][ny]) continue
                    val diff = (cluster[x][y] - cluster[nx][ny]) / 5
                    if (diff > 0) {
                        diffMap[x][y] -= diff
                        diffMap[nx][ny] += diff
                    }
                }
            }
        }
        if (oneLine.isNotEmpty()) {
            val diff = (cluster[cluster.lastIndex][cluster[0].lastIndex] - oneLine[0]) / 5
            if (diff != 0) {
                diffMap[cluster.lastIndex][cluster[0].lastIndex] -= diff
                oneLine[0] += diff
            }
        }
        for (x in cluster.indices) {
            for (y in cluster[x].indices) {
                cluster[x][y] += diffMap[x][y]
            }
        }
    }

    private fun outOfBoundary(x: Int, y: Int): Boolean {
        return x !in cluster.indices || y !in cluster[x].indices
    }

    private fun makeClusterOneLine() {
        for (y in cluster[0].lastIndex downTo 0) {
            for (x in cluster.indices) {
                oneLine.addFirst(cluster[x][y])
            }
        }
    }

    private fun rotateHalfAndMakeCluster(n: Int) {
        repeat(2) { repeat ->
            var halfPart: Array<IntArray>
            if (repeat == 0) {
                halfPart = Array(1) { IntArray(n / 2) { oneLine.removeFirst() } }
                halfPart = rotate180HalfPart(halfPart)
                cluster = Array(2) { x ->
                    if (x == 0) halfPart[0]
                    else IntArray(n / 2) { oneLine.removeFirst() }
                }
            } else {
                halfPart = Array(2) { x->
                    IntArray(n / 4) { y ->
                        cluster[x][y]
                    }
                }
                halfPart = rotate180HalfPart(halfPart)
                cluster = Array(4) { x ->
                    if (x < 2) halfPart[x]
                    else IntArray(n / 4) { y ->
                        cluster[x - 2][y + n / 4]
                    }
                }
            }
        }
    }

    private fun rotate180HalfPart(halfPart: Array<IntArray>): Array<IntArray> {
        return Array(halfPart.size) { x->
            IntArray(halfPart[x].size) { y ->
                halfPart[halfPart.size - x - 1][halfPart[x].size - y - 1]
            }
        }
    }

    private fun checkPracticeEnd(k: Int): Boolean {
        var maxCnt = 0
        var minCnt = MAX_FISH_CNT
        for (fishCnt in oneLine) {
            if (fishCnt > maxCnt) {
                maxCnt = fishCnt
            }
            if (fishCnt < minCnt) {
                minCnt = fishCnt
            }
        }
        return maxCnt - minCnt <= k
    }

/*    private fun printBowls(repeat: Int) {
        println("====$repeat 번째====")
        println(oneLine.joinToString(" "))
        println("===================")
        for (i in cluster.indices) {
            println(cluster[i].joinToString(" "))
        }
    }*/

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val st = StringTokenizer(readLine())
        repeat(n) { oneLine.add(st.nextToken().toInt()) }
        while (true) {
            if (checkPracticeEnd(k))
                break
            addFishInMinFishCntBowl()
            stackFirstFishBowl()
            rotateAndMakeCluster()
            adjustAdjFishCnt()
            makeClusterOneLine()
            rotateHalfAndMakeCluster(n)
            adjustAdjFishCnt()
            makeClusterOneLine()
            practiceTurn++
        }
        println(practiceTurn)
    }

    companion object {
        private const val MAX_FISH_CNT = Int.MAX_VALUE
    }
}

fun main() {
    `23291`().solution()
}