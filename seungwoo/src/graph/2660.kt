package graph

import java.util.LinkedList
import java.util.Queue

class `2660` {
    private val adj = Array(52) { mutableListOf<Int>() }

    private fun bfs(n: Int, st: Int): Int {
        val q = LinkedList<Int>() as Queue<Int>
        val dist = IntArray(n + 1) { -1 }
        dist[st] = 0
        q.offer(st)
        while (q.isNotEmpty()) {
            val cur = q.poll()
            for (friend in adj[cur]) {
                if (dist[friend] != -1) continue
                dist[friend] = dist[cur] + 1
                q.offer(friend)
            }
        }
        return dist.slice(1..n).maxOrNull() ?: 100
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        while (true) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            if (a == -1 && b == -1) break
            adj[a].add(b)
            adj[b].add(a)
        }
        val score = IntArray(n + 1) { bfs(n, it) }
        val minScore = score.slice(1 .. n).minOrNull() ?: 0
        val candidates = mutableListOf<Int>()
        for (i in 1 .. n) {
            if (score[i] == minScore)
                candidates.add(i)
        }
        println("$minScore ${candidates.size}\n${candidates.joinToString(" ")}")
    }
}

fun main() {
    `2660`().solution()
}