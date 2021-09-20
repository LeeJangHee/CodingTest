package baekjoon

import java.util.*

class Thirty {
    init {
        input()
    }

    private fun input() = with(Scanner(System.`in`)) {
        val n = next()
        val list = IntArray(n.length)
        var sum = 0

        for (i in n.indices) {
            list[i] = n[i].digitToInt()
            sum += list[i]
        }

        Arrays.sort(list)
        if (sum % 3 == 0 && list[0] == 0) {
            for (i in n.length - 1 downTo 0)
                print(list[i])
        }
        else {
            println(-1)
        }
    }
}

fun main() {
    Thirty()
}
