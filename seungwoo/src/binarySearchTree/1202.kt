package binarySearchTree

import java.util.HashMap
import java.util.PriorityQueue
import java.util.TreeSet

class `1202` {
    private data class Jewel(val mass: Int, val cost: Int)

    private val bagTree = TreeSet<Int>()
    private val bagMap = HashMap<Int, Int>()
    private val pq = PriorityQueue<Jewel> { o1, o2 ->
        if (o1.cost != o2.cost) o2.cost - o1.cost
        else o2.mass - o1.mass
    }

    private fun findGreedyBag(mass: Int): Int? {
        return bagTree.tailSet(mass, true).firstOrNull()
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().splitToInt()
        repeat(n) {
            val (m, v) = readLine().splitToInt()
            pq.add(Jewel(m, v))
        }
        repeat(k) {
            val c = readLine().toInt()
            bagTree.add(c)
            bagMap[c] = bagMap.getOrDefault(c, 0) + 1
        }
        var sum = 0L
        while (pq.isNotEmpty()) {
            if (bagTree.isEmpty()) break
            val (mass, cost) = pq.poll()
            findGreedyBag(mass)?.let { bag ->
                sum += cost
                if (bagMap[bag]!! > 1) {
                    bagMap[bag] = bagMap[bag]!! - 1
                } else {
                    bagTree.remove(bag)
                    bagMap.remove(bag)
                }
            }
        }
        println(sum)
    }

    private fun String.splitToInt() = split(" ").map { it.toInt() }
}

fun main() {
    `1202`().solution()
}