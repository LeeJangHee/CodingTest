package baekjoon

object BOJ15683 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private lateinit var arr: Array<IntArray>
    private var cctvCount = 0
    private var answer = Int.MAX_VALUE
    private var cctvList = arrayListOf<Pair<Int, Int>>()
    private var n = 0
    private var m = 0

    fun solve() {

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        n = N; m = M

        arr = Array(N) { IntArray(M) }
        for (i in 0 until N) {
            br.readLine()
                .split(" ")
                .forEachIndexed { j, s ->
                    arr[i][j] = s.toInt()
                    if (arr[i][j] in 1..5) {
                        cctvList.add(i to j)
                        cctvCount += 1
                    }
                }
        }

        backtracking(0)

        bw.appendLine("$answer")

        br.close()
        bw.flush()
    }

    private fun backtracking(idx: Int) {
        if (idx == cctvCount) {
            answer = minOf(answer, arr.countZero())
            return
        }

        val (x, y) = cctvList[idx]
        val copyMap = Array(n) { IntArray(m) }
        arr.copyArray(copyMap)

        when (arr[x][y]) {
            1 -> {
                // 4
                for (i in 0..3) {
                    when (i) {
                        1 -> checkRight(x, y)
                        2 -> checkLeft(x, y)
                        3 -> checkUp(x, y)
                        else -> checkDown(x, y)
                    }

                    backtracking(idx + 1)
                    copyMap.copyArray(arr)
                }
            }

            2 -> {
                // 2
                for (i in 0..1) {
                    if (i == 0) {
                        checkLeft(x, y)
                        checkRight(x, y)
                    } else {
                        checkUp(x, y)
                        checkDown(x, y)
                    }

                    backtracking(idx + 1)
                    copyMap.copyArray(arr)
                }
            }

            3 -> {
                // 4
                for (i in 0..3) {
                    when (i) {
                        1 -> {
                            checkRight(x, y)
                            checkUp(x, y)
                        }

                        2 -> {
                            checkRight(x, y)
                            checkDown(x, y)
                        }

                        3 -> {
                            checkDown(x, y)
                            checkLeft(x, y)
                        }

                        else -> {
                            checkUp(x, y)
                            checkLeft(x, y)
                        }
                    }

                    backtracking(idx + 1)
                    copyMap.copyArray(arr)
                }
            }

            4 -> {
                // 4
                for (i in 0..3) {
                    when (i) {
                        1 -> {
                            checkLeft(x, y)
                            checkRight(x, y)
                            checkUp(x, y)
                        }

                        2 -> {
                            checkUp(x, y)
                            checkRight(x, y)
                            checkDown(x, y)
                        }

                        3 -> {
                            checkRight(x, y)
                            checkDown(x, y)
                            checkLeft(x, y)
                        }

                        else -> {
                            checkDown(x, y)
                            checkUp(x, y)
                            checkLeft(x, y)
                        }
                    }

                    backtracking(idx + 1)
                    copyMap.copyArray(arr)
                }
            }

            5 -> {
                // 1
                checkUp(x, y)
                checkDown(x, y)
                checkRight(x, y)
                checkLeft(x, y)

                backtracking(idx + 1)
                copyMap.copyArray(arr)
            }
        }
    }

    private fun Array<IntArray>.copyArray(target: Array<IntArray>) {
        for (i in indices) {
            for (j in this[i].indices) {
                target[i][j] = this[i][j]
            }
        }
    }

    private fun checkLeft(x: Int, y: Int) {
        for (i in y - 1 downTo 0) {
            if (arr[x][i] == 0) {
                arr[x][i] = 9
            }
            if (arr[x][i] == 6) break
        }
    }

    private fun checkRight(x: Int, y: Int) {
        for (i in y + 1 until m) {
            if (arr[x][i] == 0) {
                arr[x][i] = 9
            }
            if (arr[x][i] == 6) break
        }
    }

    private fun checkUp(x: Int, y: Int) {
        for (i in x - 1 downTo 0) {
            if (arr[i][y] == 0) {
                arr[i][y] = 9
            }
            if (arr[i][y] == 6) break
        }
    }

    private fun checkDown(x: Int, y: Int): Int {
        var cnt = 0
        for (i in x + 1 until n) {
            if (arr[i][y] == 0) {
                arr[i][y] = 9
                cnt += 1
            }
            if (arr[i][y] == 6) break
        }

        return cnt
    }

    private fun Array<IntArray>.countZero(): Int {
        var cnt = 0
        this.forEach {
            it.forEach { i ->
                if (i == 0) {
                    cnt += 1
                }
            }
        }

        return cnt
    }
}

private fun main() {
    BOJ15683.solve()
}