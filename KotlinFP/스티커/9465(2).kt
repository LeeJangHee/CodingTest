package baekjoon

import java.lang.Integer.max
import java.util.*

class Sticker {
    init {
        initInput()
    }

    private fun <Int, R> intToArray(receiver: Int, f: (Int) -> R) = f(receiver)

    private fun ArrayList<IntArray>.maxOfArray(): Int {
        return max(this[0].last(), this[1].last())
    }

    private fun Any.print() {
        println(this)
    }

    private fun makeSticker() = { list: ArrayList<IntArray> ->
        val index = list[0].size
        for (i in 1..index-1) {
            when {
                i < 2 -> {
                    list[0][i] += list[1][i - 1]
                    list[1][i] += list[0][i - 1]
                }
                else -> {
                    list[0][i] += max(list[1][i - 2], list[1][i - 1])
                    list[1][i] += max(list[0][i - 2], list[0][i - 1])
                }
            }
        }
        list.maxOfArray()
    }

    private fun initArray(sc: Scanner) = sc.apply {
        val n = nextInt()
        val a = intToArray(n) {
            val array = ArrayList<IntArray>()
            for (i in 1..2) {
                val s = IntArray(it)
                for (j in 0 until it) {
                    s[j] = nextInt()
                }
                array.add(s)
            }
            array
        }
        makeSticker().invoke(a).print()

    }

    private fun initInput() = with(Scanner(System.`in`)) {
        var t = nextInt()
        while (t-- > 0) {
            initArray(this)
        }
    }
}


fun main() {
    Sticker()
}
