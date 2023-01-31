import java.lang.Integer.min

object Solution_15565 {

    operator fun invoke() {
        val br = System.`in`.bufferedReader()

        val (N: Int, K: Int) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }

        var lt: Int = 0
        var rt: Int = 0
        var answer: Int = Int.MAX_VALUE
        var count: Int = 0

        while (rt in lt..N) {
            if (count < K) {
                if (rt == N) break

                if (arr[rt] == 1) {
                    count++
                }
                rt++
            } else {
                answer = min(answer, rt-lt)
                if (arr[lt] == 1) {
                    count--
                }
                lt++
            }
        }

        if (answer == Int.MAX_VALUE) {
            println(-1)
        } else {
            println(answer)
        }
        br.close()
    }
}

fun main() {
    Solution_15565.invoke()
}
