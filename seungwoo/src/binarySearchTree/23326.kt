package binarySearchTree

import java.util.StringTokenizer
import java.util.TreeSet

class `23326` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, q) = readLine().split(" ").map { it.toInt() }
        var st = StringTokenizer(readLine())
        val sightTree = TreeSet<Int>()
        repeat(n) { index ->
            if (st.nextToken() == "1") {
                sightTree.add(index)
            }
        }
        var pos = 0
        val sb = StringBuilder()
        repeat(q) {
            st = StringTokenizer(readLine())
            when (st.nextToken()) {
                "1" -> {
                    val i = st.nextToken().toInt() - 1
                    if (sightTree.contains(i)) sightTree.remove(i)
                    else sightTree.add(i)
                }
                "2" -> {
                    val x = st.nextToken().toInt()
                    pos = (pos + x) % n
                }
                "3" -> {
                    if (sightTree.isEmpty()) sb.append("-1\n")
                    else {
                        val ceiling = sightTree.ceiling(pos)
                        if (ceiling != null) sb.append("${ceiling - pos}\n")
                        else sb.append("${n + sightTree.first() - pos}\n")
                    }
                }
            }
        }
        println(sb)
    }
}

fun main() {
    `23326`().solution()
}