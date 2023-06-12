import java.util.*

object BOJ1026 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {

        val N = br.readLine().toInt()
        val A = br.readLine().split(" ").map { it.toInt() }
        val B = br.readLine().split(" ").map { it.toInt() }

        // A 를 재배열 해야함.
        // B 는 건드릴 수 없음.
        var sum = 0
        Collections.sort(A) { o1, o2 ->
            o1 - o2
        }
        Collections.sort(B) { o1, o2 ->
            o2 - o1
        }

        for (i in 0 until N) {
            sum += A[i] * B[i]
        }

        bw.appendLine("$sum")
        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1026.solve()
}