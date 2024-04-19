package simulation

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

class `23289` {
    private data class Node(val x: Int, val y: Int)
    private data class Heater(val pos: Node, val dir: Int)
    private data class Wind(val pos: Node, val temp: Int = 5)

    private var map: Array<IntArray> = arrayOf()
    private var heaterMap: Array<IntArray> = arrayOf()
    private val heaters = mutableListOf<Heater>()
    private val needInvestigate = mutableListOf<Node>()
    private var walls: Array<Array<BooleanArray>> = arrayOf()
    private val d = listOf(
        Node(0, 1),
        Node(0, -1),
        Node(-1, 0),
        Node(1, 0),
    )
    private val windD = listOf(
        listOf(Node(0, 0), Node(1, 0), Node(-1, 0)),
        listOf(Node(0, 0), Node(0, -1), Node(0, 1))
    )
    private var chocolates = 0

    private fun makeHeaterMap(r: Int, c: Int) {
        heaterMap = Array(r) { IntArray(c) }
        for (heater in heaters) {
            windComesOut(heater, r, c)
        }
    }

    private fun windComesOut(heater: Heater, r: Int, c: Int) {
        val (heaterPos, dir) = heater
        val (dx, dy) = d[dir]
        val q = LinkedList<Wind>() as Queue<Wind>
        val visited = Array(r) { BooleanArray(c) }
        val startX = heaterPos.x + dx
        val startY = heaterPos.y + dy
        q.offer(Wind(Node(startX, startY)))
        visited[startX][startY] = true
        while (q.isNotEmpty()) {
            val (pos, temp) = q.poll()
            heaterMap[pos.x][pos.y] += temp
            if (temp == 1) continue
            for ((idx, offset) in windD[dir / 2].withIndex()) {
                val nx = pos.x + dx + offset.x
                val ny = pos.y + dy + offset.y
                if (outOfBoundary(nx, ny) || visited[nx][ny]) continue
                if (wallExist(pos, offset, dir, idx)) continue
                q.offer(Wind(Node(nx, ny), temp - 1))
                visited[nx][ny] = true
            }
        }
    }

    private fun wallExist(cur: Node, offset: Node, dir: Int, idx: Int): Boolean {
        if (idx == 0) return walls[cur.x][cur.y][dir]
        val checkX = cur.x + offset.x
        val checkY = cur.y + offset.y
        val checkDir = if (dir / 2 == 0) idx + 1 else idx - 1
        return walls[checkX][checkY][dir] || walls[checkX][checkY][checkDir]
    }


    private fun heatersWork() {
        for (x in map.indices) {
            for (y in map[x].indices) {
                map[x][y] += heaterMap[x][y]
            }
        }
    }

    private fun heatTransfer(r: Int, c: Int) {
        val heatMap = Array(r) { IntArray(c) }
        for (x in map.indices) {
            for (y in map[x].indices) {
                for (i in d.indices) {
                    val nx = x + d[i].x
                    val ny = y + d[i].y
                    if (outOfBoundary(nx, ny) || walls[x][y][i]) continue
                    if (map[x][y] - map[nx][ny] >= 4) {
                        val diff = (map[x][y] - map[nx][ny]) / 4
                        heatMap[x][y] -= diff
                        heatMap[nx][ny] += diff
                    }
                }
            }
        }
        for (x in map.indices) {
            for (y in map[x].indices) {
                map[x][y] += heatMap[x][y]
            }
        }
    }

    private fun boundaryTempDecrease(r: Int, c: Int) {
        listOf(0, c - 1).forEach { y ->
            for (x in map.indices) {
                if (map[x][y] > 0) {
                    map[x][y]--
                }
            }
        }
        listOf(0, r - 1).forEach { x ->
            for (y in 1 until c - 1) {
                if (map[x][y] > 0) {
                    map[x][y]--
                }
            }
        }
    }

    private fun investigate(k: Int): Boolean {
        for (pos in needInvestigate) {
            if (map[pos.x][pos.y] < k)
                return false
        }
        return true
    }

    private fun outOfBoundary(x: Int, y: Int): Boolean {
        return x !in map.indices || y !in map[x].indices
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (r, c, k) = readLine().splitToInt()
        map = Array(r) { x ->
            val st = StringTokenizer(readLine())
            IntArray(c) { y ->
                when (val num = st.nextToken().toInt()) {
                    in 1 .. 4 -> heaters.add(Heater(Node(x, y), num - 1))
                    5 -> needInvestigate.add(Node(x, y))
                }
                0
            }
        }
        val w = readLine().toInt()
        walls = Array(r) { Array(c) { BooleanArray(4) } }
        repeat(w) {
            val (x, y, t) = readLine().splitToInt()
            when(t) {
                0 -> walls[x - 1][y - 1][2] = true.also { walls[x - 2][y - 1][3] = true }
                1 -> walls[x - 1][y - 1][0] = true.also { walls[x - 1][y][1] = true }
            }
        }
        makeHeaterMap(r, c)
        while (chocolates <= 100) {
            heatersWork()
            heatTransfer(r, c)
            boundaryTempDecrease(r, c)
            chocolates++
            if (investigate(k)) break
        }
        println(chocolates)
    }

    private fun String.splitToInt(): List<Int> = split(" ").map { it.toInt() }
}

fun main() {
    `23289`().solution()
}