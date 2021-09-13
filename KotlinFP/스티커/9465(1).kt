package baekjoon

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

class Stickers1 {
    init {
        input()
    }

    private fun Int.makeInit(sc: Scanner) = run {
        val s = ArrayList<IntArray>()
        for (i in 0 until 2) {
            val array = IntArray(this)
            for (j in 0 until this) {
                array[j] = sc.nextInt()
            }
            s.add(array)
        }
        s
    }

    private fun ArrayList<IntArray>.maxValue(): Int {
        return max(this[0].last(), this[1].last())
    }

    private fun Any.printSticker() {
        println(this)
    }

    private tailrec fun arrayToInt(list: ArrayList<IntArray>, i: Int, j: Int): ArrayList<IntArray> = when {
        i < 0 || i >= list.size || j < 0 || j >= list[0].size -> list
        j < 2 -> {
            list[i][j] += list[i + 1][j - 1]
            list[i + 1][j] += list[i][j - 1]
            arrayToInt(list, i, j + 1)
        }
        else -> {
            list[i + 1][j] += max(list[i][j - 2], list[i][j - 1])
            list[i][j] += max(list[i + 1][j - 2], list[i + 1][j - 1])
            arrayToInt(list, i, j + 1)
        }
    }


    private fun initSticker(sc: Scanner) {
        val n = sc.nextInt()
        arrayToInt(n.makeInit(sc), 0, 1).maxValue().printSticker()
    }

    private fun input() = with(Scanner(System.`in`)) {
        var t = nextInt()
        while (t-- > 0) {
            initSticker(this)
        }
    }
}

fun main() {
    Stickers1()
}
