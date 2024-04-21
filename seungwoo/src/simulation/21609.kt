package simulation

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import java.util.Stack
import java.util.StringTokenizer

class `21609` {
    private data class Node(val x: Int, val y: Int)
    private data class BlockGroup(
        val blocksPos: Queue<Node>,
        val rainbowBlockCnt: Int
    ) : Comparable<BlockGroup> {
        private fun standardBlockPos() = blocksPos.peek()

        override fun compareTo(other: BlockGroup): Int {
            return if (blocksPos.size != other.blocksPos.size) other.blocksPos.size - blocksPos.size
            else if (rainbowBlockCnt != other.rainbowBlockCnt) other.rainbowBlockCnt - rainbowBlockCnt
            else if (standardBlockPos().x != other.standardBlockPos().x) other.standardBlockPos().x - standardBlockPos().x
            else other.standardBlockPos().y - standardBlockPos().y
        }
    }

    private var board: Array<IntArray> = arrayOf()
    private val blockGroups = PriorityQueue<BlockGroup>()
    private val d = listOf(
        Node(1, 0),
        Node(-1, 0),
        Node(0, 1),
        Node(0, -1)
    )
    private var score = 0

    private fun findBlockGroups() {
        blockGroups.clear()
        val visited = Array(board.size) { BooleanArray(board.size) }
        for (x in board.indices) {
            for (y in board.indices) {
                val color = board[x][y]
                if (color == BLACK || color == RAINBOW || color == EMPTY) continue
                if (visited[x][y]) continue
                findBlockGroup(x, y, board[x][y], visited)
            }
        }
    }

    private fun findBlockGroup(startX: Int, startY: Int, target: Int, visited: Array<BooleanArray>) {
        val q = LinkedList<Node>() as Queue<Node>
        val blocksPos = LinkedList<Node>() as Queue<Node>
        val groupVisited = Array(board.size) { BooleanArray(board.size) }
        var rainbowBlockCnt = 0
        q.offer(Node(startX, startY))
        visited[startX][startY] = true
        groupVisited[startX][startY] = true
        while (q.isNotEmpty()) {
            val pos = q.poll()
            blocksPos.offer(pos)
            if (board[pos.x][pos.y] == RAINBOW) rainbowBlockCnt++
            for (i in d.indices) {
                val nx = pos.x + d[i].x
                val ny = pos.y + d[i].y
                if (nx !in board.indices || ny !in board.indices || groupVisited[nx][ny]) continue
                if (board[nx][ny] == target) {
                    q.offer(Node(nx, ny))
                    visited[nx][ny] = true
                    groupVisited[nx][ny] = true
                } else if (board[nx][ny] == RAINBOW) {
                    q.offer(Node(nx, ny))
                    groupVisited[nx][ny] = true
                }
            }
        }
        if (blocksPos.size >= 2) {
            blockGroups.add(BlockGroup(blocksPos, rainbowBlockCnt))
        }
    }

    private fun autoPlay() {
        removeBiggestBlockGroup()
        blocksFall()
        rotateBoard()
        blocksFall()
    }

    private fun removeBiggestBlockGroup() {
        val blocksPos = blockGroups.poll().blocksPos
        score += blocksPos.size * blocksPos.size
        while (blocksPos.isNotEmpty()) {
            val (x, y) = blocksPos.poll()
            board[x][y] = EMPTY
        }
    }

    private fun blocksFall() {
        val stack = Stack<Int>()
        for (y in board.indices) {
            for (x in board.indices) {
                val color = board[x][y]
                if (color == EMPTY && x < board.lastIndex && board[x + 1][y] == EMPTY) continue
                if (color == BLACK || x == board.lastIndex) {
                    var idx = if (color == EMPTY) x else x - 1
                    while (stack.isNotEmpty()) {
                        board[idx][y] = stack.pop()
                        idx--
                    }
                } else if (color != EMPTY) {
                    stack.push(color)
                    board[x][y] = EMPTY
                }
            }
        }
    }

    private fun rotateBoard() {
        board = Array(board.size) { x ->
            IntArray(board.size) { y ->
                board[y][board.size - x - 1]
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        board = Array(n) {
            val st = StringTokenizer(readLine())
            IntArray(n) { st.nextToken().toInt() }
        }
        while (true) {
            findBlockGroups()
            if (blockGroups.isEmpty()) break
            autoPlay()
        }
        println(score)
    }

    companion object {
        const val EMPTY = 9
        const val BLACK = -1
        const val RAINBOW = 0
    }
}

fun main() {
    `21609`().solution()
}