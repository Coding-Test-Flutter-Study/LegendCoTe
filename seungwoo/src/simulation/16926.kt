package simulation

import java.util.StringTokenizer
import kotlin.math.min

class `16926` {
    private var arr: Array<IntArray> = arrayOf()
    private val d = listOf(
        Pair(0, 1),
        Pair(1, 0),
        Pair(0, -1),
        Pair(-1, 0),
    )

    private fun spinArr(n: Int, m: Int, r: Int): Array<IntArray> {
        val spunArr = Array(n) { IntArray(m) }
        var level = 0
        var cnt = (n + m) * 2 - 4
        while (level < min(n, m) / 2) {
            val colSize = n - level * 2
            val rowSize = m - level * 2
            val lastColIdx = level + colSize - 1
            val lastRowIdx = level + rowSize - 1
            val circularArr = getCircularArr(cnt, lastColIdx, lastRowIdx, level)
            spunArr.insertRotatedNum(circularArr, lastColIdx, lastRowIdx, r % cnt, level)
            cnt -= 8
            level++
        }
        return spunArr
    }

    private fun getCircularArr(cnt: Int, lastColIdx: Int, lastRowIdx: Int, level: Int): IntArray {
        val circularArr = IntArray(cnt)
        var x = level
        var y = level
        var dir = 0
        for (i in circularArr.indices) {
            circularArr[i] = arr[x][y]
            if (needChangeDir(x, y, lastColIdx, lastRowIdx, level))
                dir++
            x += d[dir].first
            y += d[dir].second
        }
        return circularArr
    }

    private fun Array<IntArray>.insertRotatedNum(
        circularArr: IntArray,
        lastColIdx: Int,
        lastRowIdx: Int,
        realR: Int,
        level: Int
    ) {
        var idx = realR
        var x = level
        var y = level
        var dir = 0
        repeat(circularArr.size) {
            this[x][y] = circularArr[idx]
            if (needChangeDir(x, y, lastColIdx, lastRowIdx, level))
                dir++
            x += d[dir].first
            y += d[dir].second
            idx = if (idx != circularArr.lastIndex) idx + 1 else 0
        }
    }

    private fun needChangeDir(x: Int, y: Int, lastColIdx: Int, lastRowIdx: Int, level: Int): Boolean {
        return (x == level && y == lastRowIdx) || (x == lastColIdx && y == lastRowIdx) || (x == lastColIdx && y == level)
    }

    private fun printArr(arr: Array<IntArray>) {
        val sb = StringBuilder()
        for (i in arr.indices) {
            sb.append(arr[i].joinToString(" ")).append("\n")
        }
        println(sb)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m, r) = readLine().split(" ").map { it.toInt() }
        arr = Array(n) {
            val st = StringTokenizer(readLine())
            IntArray(m) { st.nextToken().toInt() }
        }
        val spunArr = spinArr(n, m, r)
        printArr(spunArr)
    }
}

fun main() {
    `16926`().solution()
}