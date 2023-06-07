package baekjoon

object BOJ13144 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var ans = 0L

    fun solve() {
        val N = br.readLine().toInt()
        val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
        val visited = BooleanArray(N + 1)

        /*
        1. lt -> 0~N 까지 for 문을 돈다.
        2. while (rt < N)에서 lt 에서 가질 수 있는 경우의 수를 구한다.
        3. while 문이 끝나면 lt~rt 의 경우의 수가 구해지기 때문에
        4. ans += (rt - lt) 를 실행한다.
        5. lt는 방문 처리를 제거 후 다음 번호로 이동한다.
         */
        var rt = 0
        for (lt in 0 until N) {
            while (rt < N) {
                if (visited[arr[rt]]) break
                visited[arr[rt]] = true
                rt += 1
            }

            ans += (rt - lt)
            visited[arr[lt]] = false
        }

        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ13144.solve()
}