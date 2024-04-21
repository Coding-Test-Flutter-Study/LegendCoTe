package simulation

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

class `23288` {
    private data class Node(val x: Int, val y: Int)
    private data class Dice(var pos: Node, var dir: Int)

    private var board: Array<IntArray> = arrayOf()
    private var scoreBoard: Array<IntArray> = arrayOf()
    private val d = listOf(
        Node(0, 1),
        Node(-1, 0),
        Node(0, -1),
        Node(1, 0)
    )
    private val dice = Dice(Node(0, 0), 0)
    private var diceNum = intArrayOf(1, 2, 3, 4, 5, 6)
    private var score = 0

    private fun makeScoreBoard(n: Int, m: Int) {
        scoreBoard = Array(n) { IntArray(m) }
        val visited = Array(n) { BooleanArray(m) }
        for (x in board.indices) {
            for (y in board[x].indices) {
                if (visited[x][y]) continue
                bfs(x, y, board[x][y], visited)
            }
        }
    }

    private fun bfs(startX: Int, startY: Int, target: Int, visited: Array<BooleanArray>) {
        val nodes = LinkedList<Node>() as Queue<Node>
        val q = LinkedList<Node>() as Queue<Node>
        q.offer(Node(startX, startY))
        visited[startX][startY] = true
        while (q.isNotEmpty()) {
            val node = q.poll()
            nodes.offer(node)
            for (i in d.indices) {
                val nx = node.x + d[i].x
                val ny = node.y + d[i].y
                if (nx !in board.indices || ny !in board[0].indices || visited[nx][ny]) continue
                if (board[nx][ny] == target) {
                    q.offer(Node(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }
        val score = nodes.size * target
        while (nodes.isNotEmpty()) {
            val (x, y) = nodes.poll()
            scoreBoard[x][y] = score
        }
    }

    private fun moveDice() {
        val (x, y) = dice.pos
        var dir = dice.dir
        var nx = x + d[dir].x
        var ny = y + d[dir].y
        if (nx !in board.indices || ny !in board[0].indices) {
            dir = (dir + 2) % d.size
            nx = x + d[dir].x
            ny = y + d[dir].y
        }
        dice.pos = Node(nx, ny)
        dice.dir = dir
        val newDiceNum = diceNum.copyOf()
        when (dir) {
            0 -> {
                newDiceNum[0] = diceNum[3]
                newDiceNum[2] = diceNum[0]
                newDiceNum[3] = diceNum[5]
                newDiceNum[5] = diceNum[2]
            }
            1 -> {
                newDiceNum[0] = diceNum[4]
                newDiceNum[1] = diceNum[0]
                newDiceNum[4] = diceNum[5]
                newDiceNum[5] = diceNum[1]
            }
            2 -> {
                newDiceNum[0] = diceNum[2]
                newDiceNum[2] = diceNum[5]
                newDiceNum[3] = diceNum[0]
                newDiceNum[5] = diceNum[3]
            }
            3 -> {
                newDiceNum[0] = diceNum[1]
                newDiceNum[1] = diceNum[5]
                newDiceNum[4] = diceNum[0]
                newDiceNum[5] = diceNum[4]
            }
        }
        diceNum = newDiceNum
    }

    private fun getScore() {
        score += scoreBoard[dice.pos.x][dice.pos.y]
    }

    private fun rotateDice() {
        val a = diceNum[5]
        val b = board[dice.pos.x][dice.pos.y]
        val dir = dice.dir
        if (a > b) {
            dice.dir = if (dir == 0) 3 else dir - 1
        } else if (a < b) {
            dice.dir = (dir + 1) % d.size
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m, k) = readLine().split(" ").map { it.toInt() }
        board = Array(n) {
            val st = StringTokenizer(readLine())
            IntArray(m) { st.nextToken().toInt() }
        }
        makeScoreBoard(n, m)
        repeat(k) {
            moveDice()
            getScore()
            rotateDice()
        }
        println(score)
    }
}

fun main() {
    `23288`().solution()
}