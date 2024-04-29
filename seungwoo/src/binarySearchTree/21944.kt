package binarySearchTree

import java.util.HashMap
import java.util.TreeSet

class `21944` {
    private data class Problem(val num: Int, val level: Int, val group: Int): Comparable<Problem> {
        override fun compareTo(other: Problem): Int {
            return if (level == other.level) num - other.num
            else level - other.level
        }
    }

    private val tree = TreeSet<Problem>()
    private val groupTree = HashMap<Int, TreeSet<Problem>>()
    private val levelMap = HashMap<Int, Int>()
    private val groupMap = HashMap<Int, Int>()

    private fun add(p: Int, l: Int, g: Int) {
        val problem = Problem(p, l, g)
        tree.add(problem)
        groupTree.getOrPut(g) { TreeSet() }.add(problem)
        levelMap[p] = l
        groupMap[p] = g
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        repeat(n) {
            val (p, l, g) = readLine().split(" ").map { it.toInt() }
            add(p, l, g)
        }
        val m = readLine().toInt()
        val sb = StringBuilder()
        repeat(m) {
            val command = readLine().split(" ")
            when (command[0]) {
                "recommend" -> {
                    val g = command[1].toInt()
                    val x = command[2].toInt()
                    sb.appendLine(
                        if (x == 1) groupTree[g]!!.last().num
                        else groupTree[g]!!.first().num
                    )
                }
                "recommend2" -> {
                    val x = command[1].toInt()
                   sb.appendLine(
                       if (x == 1) tree.last().num
                       else tree.first().num
                   )
                }
                "recommend3" -> {
                    val x = command[1].toInt()
                    val l = command[2].toInt()
                    sb.appendLine(
                        if (x == 1)  tree.ceiling(Problem(0, l, 0))?.num ?: -1
                        else tree.floor(Problem(0, l, 0))?.num ?: -1
                    )
                }
                "add" -> {
                    val (p, l, g) = command.subList(1, 4).map { it.toInt() }
                    add(p, l, g)
                }
                "solved" -> {
                    val p = command[1].toInt()
                    val l = levelMap[p]!!
                    val g = groupMap[p]!!
                    tree.remove(Problem(p, l, g))
                    groupTree[g]?.remove(Problem(p, l, g))
                    levelMap.remove(p)
                    groupMap.remove(p)
                }
            }
        }
        println(sb)
    }
}

fun main() {
    `21944`().solution()
}