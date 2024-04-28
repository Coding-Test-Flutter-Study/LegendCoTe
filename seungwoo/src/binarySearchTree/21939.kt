package binarySearchTree

import java.util.HashMap
import java.util.TreeSet

class `21939` {
    private data class Problem(val num: Int, val level: Int)

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val tree = TreeSet<Problem> { o1, o2 ->
            if (o1.level != o2.level) o1.level - o2.level
            else o1.num - o2.num
        }
        val map = HashMap<Int, Int>()
        repeat(n) {
            val (p, l) = readLine().split(" ").map { it.toInt() }
            tree.add(Problem(p, l))
            map[p] = l
        }
        val m = readLine().toInt()
        val sb = StringBuilder()
        repeat(m) {
            val commandArr = readLine().split(" ")
            when (commandArr[0]) {
                "recommend" -> {
                    val x = commandArr[1].toInt()
                    if (x == 1) sb.append("${tree.last().num}\n")
                    else sb.append("${tree.first().num}\n")
                }
                "add" -> {
                    val p = commandArr[1].toInt()
                    val l = commandArr[2].toInt()
                    tree.add(Problem(p, l))
                    map[p] = l
                }
                "solved" -> {
                    val p = commandArr[1].toInt()
                    tree.remove(Problem(p, map[p]!!))
                }
            }
        }
        println(sb)
    }
}

fun main() {
    `21939`().solution()
}