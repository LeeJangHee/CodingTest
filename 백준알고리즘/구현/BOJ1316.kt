package baekjoon

object BOJ1316 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var ans = 0
    fun solve() {
        val N = br.readLine().toInt()
        val list = mutableListOf<String>()
        for (i in 1..N) {
            list.add(br.readLine())
        }

        for (word in list) {
            var prev = word.first()
            val strSet = mutableSetOf(prev)
            var flag = true
            for (i in 1 until word.length) {
                if (prev != word[i]) {
                    if (strSet.contains(word[i])) {
                        flag = false
                        break
                    } else {
                        strSet.add(word[i])
                        prev = word[i]
                    }
                }
            }

            if (flag) ans += 1
        }

        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1316.solve()
}