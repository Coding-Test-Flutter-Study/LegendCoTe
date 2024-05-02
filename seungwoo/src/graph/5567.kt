package graph

class `5567` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val m = readLine().toInt()
        val graph = Array(n + 1) { BooleanArray(n + 1) }
        val friends = HashSet<Int>()
        repeat(m) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            if (a == 1 || b == 1) {
                friends.add(a)
                friends.add(b)
            } else {
                graph[a][b] = true
                graph[b][a] = true
            }
        }
        friends.remove(1)
        val friendsOfFriends = HashSet<Int>()
        for (friend in friends) {
            for (i in 2 .. n) {
                if (graph[friend][i]) {
                    friendsOfFriends.add(i)
                }
            }
        }
        val total = friends + friendsOfFriends
        println(total.size)
    }
}

fun main() {
    `5567`().solution()
}