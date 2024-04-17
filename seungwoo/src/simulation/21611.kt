package simulation

import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import java.util.StringTokenizer

class `21611` {
    private var mapArr = intArrayOf()
    private val marvelStack = Stack<Int>()
    private val marvelQueue = LinkedList<Int>() as Queue<Int>
    private val dirFirstSum = intArrayOf(0, 7, 3, 1, 5)
    private val d = listOf(
        Pair(0, -1),
        Pair(1, 0),
        Pair(0, 1),
        Pair(-1, 0)
    )
    private val score = IntArray(4)

    private fun insertMapArr(n: Int, map: Array<IntArray>) {
        mapArr = IntArray(n * n)
        var x = n / 2
        var y = n / 2
        var dir = 0
        var len = 1
        var idx = 0
        while (true) {
            repeat(len) {
                mapArr[idx] = map[x][y]
                x += d[dir].first
                y += d[dir].second
                idx++
                if (idx == mapArr.size) return
            }
            dir = (dir + 1) % d.size
            if (dir % 2 == 0) len++
        }
    }

    private fun blizzardMagic(d: Int, s: Int) {
        var idx = 0
        var sum = dirFirstSum[d]
        repeat(s) {
            idx += sum
            mapArr[idx] = EMPTY
            sum += 8
        }
    }

    private fun fillEmpty() {
        for (i in mapArr.lastIndex downTo 1) {
            if (mapArr[i] == EMPTY) continue
            marvelStack.push(mapArr[i])
            mapArr[i] = EMPTY
        }
        var idx = 1
        while (marvelStack.isNotEmpty()) {
            mapArr[idx] = marvelStack.pop()
            idx++
        }
    }

    private fun marvelsExplode(): Boolean {
        var isExplode = false
        var s = 1
        var e = 1
        while (s < mapArr.size && mapArr[s] != EMPTY) {
            val target = mapArr[s]
            while (true) {
                if (e < mapArr.lastIndex && mapArr[e + 1] == target) {
                    e++
                } else break
            }
            val cnt = e - s + 1
            if (cnt >= 4) {
                isExplode = true
                score[target] += cnt
                for (i in e downTo s) {
                    mapArr[i] = EMPTY
                }
            }
            s = e + 1
        }
        return isExplode
    }

    private fun groupsChange() {
        var s = 1
        var e = 1
        while (s < mapArr.size && mapArr[s] != EMPTY) {
            val target = mapArr[s]
            while (true) {
                if (e < mapArr.lastIndex && mapArr[e + 1] == target) {
                    e++
                } else break
            }
            val cnt = e - s + 1
            with(marvelQueue) {
                offer(cnt)
                offer(target)
            }
            s = e + 1
        }
        var idx = 1
        while (marvelQueue.isNotEmpty() && idx < mapArr.size) {
            mapArr[idx] = marvelQueue.poll()
            idx++
        }
        marvelQueue.clear()
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().splitToInt()
        val map = Array(n) {
            val st = StringTokenizer(readLine())
            IntArray(n) { st.nextToken().toInt() }
        }
        insertMapArr(n, map)
        repeat(m) {
            val (d, s) = readLine().splitToInt()
            blizzardMagic(d, s)
            fillEmpty()
            while (true) {
                if (!marvelsExplode())
                    break
                fillEmpty()
            }
            groupsChange()
        }
        val score = score.mapIndexed { index, i -> index * i }.sum()
        println(score)
    }

    private fun String.splitToInt(): List<Int> = split(" ").map { it.toInt() }

    companion object {
        private const val EMPTY = 0
    }
}

fun main() {
    `21611`().solution()
}