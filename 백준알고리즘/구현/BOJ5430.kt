package kr.baekjoon

object BOJ5430 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        var t = br.readLine().toInt()

        // 10^2
        while (t-- > 0) {
            // 10^6
            val p = br.readLine()
            val n = br.readLine().toInt()
            val arr = br.readLine()
                .replace("[", "")
                .replace("]", "")
                .replace(",", " ")
                .trim()
                .split(Regex("\\s"))

            val dq = ArrayDeque(arr)

            if (p.count { it == 'D' } > n) {
                bw.appendLine("error")
                continue
            }

            var isReveres = false
            p.forEach {
                if (it == 'R') {
                    isReveres = !isReveres
                } else {
                    if (isReveres) {
                        // 뒤에서
                        dq.removeLast()
                    } else {
                        // 앞에서
                        dq.removeFirst()
                    }
                }
            }

            if (isReveres) dq.reverse()

            bw.appendLine(
                dq.joinToString(
                    separator = ",",
                    prefix = "[",
                    postfix = "]"
                )
            )
        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ5430.solve()
}