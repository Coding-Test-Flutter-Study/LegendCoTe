package simulation

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

class `23290` {
    private data class Node(var x: Int, var y: Int, val dir: Int = 0)

    private var map = Array(4) { Array(4) { ArrayDeque<Int>() } }
    private val smellMap = Array(4) { IntArray(4) }
    private val fishQ = LinkedList<Node>() as Queue<Node>
    private val sharkQ = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        if (o1.first != o2.first) o2.first - o1.first
        else o1.second - o2.second
    }
    private val shark = Node(0, 0)
    private val fishD = listOf(
        Node(0, -1),
        Node(-1, -1),
        Node(-1, 0),
        Node(-1, 1),
        Node(0, 1),
        Node(1, 1),
        Node(1, 0),
        Node(1, -1)
    )
    private val sharkD = listOf(
        Node(-1, 0),
        Node(0, -1),
        Node(1, 0),
        Node(0, 1)
    )
    private var turn = 0

    private fun copyMagic() {
        for (x in map.indices) {
            for (y in map[x].indices) {
                for (dir in map[x][y]) {
                    fishQ.offer(Node(x, y, dir))
                }
            }
        }
    }

    private fun moveFish() {
        val newMap = Array(4) { Array(4) { ArrayDeque<Int>() } }
        for (x in map.indices) {
            for (y in map.indices) {
                while (map[x][y].isNotEmpty()) {
                    val dir = map[x][y].removeFirst()
                    val newDir = findFishDir(x, y, dir)
                    if (newDir < 0) newMap[x][y].addLast(dir)
                    else newMap[x + fishD[newDir].x][y + fishD[newDir].y].addLast(newDir)
                }
            }
        }
        map = newMap
    }

    private fun findFishDir(x: Int, y: Int, dir: Int): Int {
        for (i in fishD.indices) {
            var newDir = dir - i
            if (newDir < 0) newDir += 8
            val nx = x + fishD[newDir].x
            val ny = y + fishD[newDir].y
            if (outOfBoundary(nx, ny) || isSharkPos(nx, ny) || smellMap[nx][ny] > 0) continue
            return newDir
        }
        return -1
    }

    private fun isSharkPos(x: Int, y: Int): Boolean {
        return x == shark.x && y == shark.y
    }

    private fun moveShark() {
        findSharkPath(shark.x, shark.y)
        sharkQ.poll().second.toString().forEach { path ->
            val dir = path.digitToInt() - 1
            val nx = shark.x + sharkD[dir].x
            val ny = shark.y + sharkD[dir].y
            if (map[nx][ny].isNotEmpty()) {
                smellMap[nx][ny] = turn + 2
                map[nx][ny].clear()
            }
            shark.x = nx.also { shark.y = ny }
        }
        sharkQ.clear()
    }

    private fun findSharkPath(
        x: Int,
        y: Int,
        depth: Int = 0,
        fishCnt: Int = 0,
        path: IntArray = IntArray(3),
        visited: Array<BooleanArray> = Array(4) { BooleanArray(4) }
    ) {
        if (depth == path.size) {
            val pathNum = path[0] * 100 + path[1] * 10 + path[2]
            sharkQ.add(Pair(fishCnt, pathNum))
            return
        }
        for (i in 1 .. 4) {
            val nx = x + sharkD[i - 1].x
            val ny = y + sharkD[i - 1].y
            if (outOfBoundary(nx, ny)) continue
            path[depth] = i
            val cnt = if (!visited[nx][ny]) map[nx][ny].size else 0
            if (depth != 0) visited[x][y] = true
            findSharkPath(nx, ny, depth + 1, fishCnt + cnt, path, visited)
            if (depth != 0) visited[x][y] = false
        }
    }

    private fun removeSmell() {
        for (x in smellMap.indices) {
            for (y in smellMap[x].indices) {
                if (smellMap[x][y] == turn) {
                    smellMap[x][y] = 0
                }
            }
        }
    }

    private fun copyFish() {
        while (fishQ.isNotEmpty()) {
            val (x, y, dir) = fishQ.poll()
            map[x][y].add(dir)
        }
    }

    private fun calcRemainFishCnt(): Int {
        return map.sumOf { arr -> arr.sumOf { it.size } }
    }

    private fun outOfBoundary(x: Int, y: Int): Boolean {
        return x !in map.indices || y !in map[x].indices
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (m, s) = readLine().splitToInt()
        repeat(m) {
            val (fx, fy, d) = readLine().splitToInt(offset = 1)
            map[fx][fy].add(d)
        }
        val (sx, sy) = readLine().splitToInt(offset = 1)
        shark.x = sx.also { shark.y = sy }
        repeat(s) {
            copyMagic()
            moveFish()
            moveShark()
            removeSmell()
            copyFish()
            turn++
        }
        println(calcRemainFishCnt())
    }

    private fun String.splitToInt(offset: Int = 0) = split(" ").map { it.toInt() - offset }
}

fun main() {
    `23290`().solution()
}