package baekjoon

import java.util.*
import kotlin.collections.ArrayDeque

object BOJ14891 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private const val COMP_RIGHT = 2
    private const val COMP_LEFT = 6

    // last pop -> first put
    private const val DEFAULT_DIR = 1

    private lateinit var arr: Array<ArrayDeque<Int>>
    private var visited = BooleanArray(4)
    private var baseCase = LinkedList<Pair<Int, Int>>()
    fun solve() {

        arr = Array(4) { ArrayDeque<Int>() }

        for (i in 0..3) {
            val data = br.readLine().map { it.digitToInt() }
            arr[i] = ArrayDeque(data)
        }

        val K = br.readLine().toInt()
        for (i in 0 until K) {
            val (id, dir) = br.readLine().split(" ").map { it.toInt() }
            calc(id - 1, dir)
            while (baseCase.isNotEmpty()) {
                val (x, dx) = baseCase.poll()
                if (dx == DEFAULT_DIR) {
                    // last pop -> first put
                    val last = arr[x].removeLast()
                    arr[x].addFirst(last)
                } else {
                    // first pop -> last put
                    val first = arr[x].removeFirst()
                    arr[x].addLast(first)
                }
            }
        }

        var ans = 0
        for (i in 0..3) {
            ans += (arr[i][0] shl i)
        }
        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }

    private fun calc(i: Int, dir: Int) {
        if (!visited[i]) {
            visited[i] = true
            baseCase.offer(i to dir)
            when (i) {
                0 -> {
                    if (arr[0][COMP_RIGHT] != arr[1][COMP_LEFT]) {
                        calc(1, -dir)
                    }
                }

                3 -> {
                    if (arr[3][COMP_LEFT] != arr[2][COMP_RIGHT]) {
                        calc(2, -dir)
                    }
                }

                else -> {
                    if (arr[i][COMP_LEFT] != arr[i - 1][COMP_RIGHT]) {
                        calc(i - 1, -dir)
                    }

                    if (arr[i][COMP_RIGHT] != arr[i + 1][COMP_LEFT]) {
                        calc(i + 1, -dir)
                    }
                }
            }
            visited[i] = false
        }
    }
}

private fun main() {
    BOJ14891.solve()
}