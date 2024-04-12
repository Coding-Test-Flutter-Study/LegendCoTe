import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val N = this.readLine().toInt()

    val dp = Array(N + 1) { LongArray(2) }

    dp[1][0] = 0
    dp[1][1] = 1

    for (i in 2..N) {
        for (j in 0 until 2) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][1] + dp[i - 1][0]
            } else if (j == 1) {
                dp[i][j] = dp[i - 1][0]
            }
        }
    }
    bw.write("${dp[N][0]} + ${dp[N][1]}")
    bw.flush()
    bw.close()
}
