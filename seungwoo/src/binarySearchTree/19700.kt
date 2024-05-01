package binarySearchTree

import java.util.PriorityQueue
import java.util.TreeSet

class `19700` {
    private val students = PriorityQueue<Pair<Int, Int>>(compareBy { -it.first })
    private val teams = TreeSet<Int>()
    private val teamCntMap = HashMap<Int, Int>()

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        repeat(n) {
            val (h, k) = readLine().split(" ").map { it.toInt() }
            students.add(h to k)
        }
        while (students.isNotEmpty()) {
            val rank = students.poll().second
            val target = teams.ceiling(-rank + 1)
            if (target == null) {
                teams.add(-1)
                teamCntMap[-1] = teamCntMap.getOrDefault(-1, 0) + 1
            }
            else {
                if (teamCntMap[target]!! == 1) {
                    teams.remove(target)
                    teamCntMap.remove(target)
                } else teamCntMap[target] = teamCntMap[target]!! - 1
                teams.add(target - 1)
                teamCntMap[target - 1] = teamCntMap.getOrDefault(target - 1, 0) + 1
            }
        }
        var teamCnt = 0
        val iter = teamCntMap.iterator()
        while (iter.hasNext()) {
            teamCnt += iter.next().value
        }
        println(teamCnt)
    }
}

fun main() {
    `19700`().solution()
}